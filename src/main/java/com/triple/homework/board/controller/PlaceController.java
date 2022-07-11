package com.triple.homework.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.triple.homework.board.domain.Place_infoVO;
import com.triple.homework.board.domain.Review_mstVO;
import com.triple.homework.board.domain.Review_dtlVO;
import com.triple.homework.board.domain.Point_hstVO;
import com.triple.homework.board.domain.User_infoVO;

import com.triple.homework.board.service.PlaceService;
import com.triple.homework.board.service.Review_dtlService;
import com.triple.homework.board.service.Review_mstService;



@Controller
public class PlaceController {

	@Resource(name="com.triple.homework.board.service.PlaceService")
	PlaceService placeService;
	@Resource(name="com.triple.homework.board.service.Review_mstService")
	Review_mstService review_mstService;
	@Resource(name="com.triple.homework.board.service.Review_dtlService")
	Review_dtlService review_dtlService;
	
	@Transactional(rollbackFor = Exception.class)
	@RequestMapping("/list") //게시판 리스트 화면 호출
	private String placeList(Model model) throws Exception{
		model.addAttribute("list", placeService.placeListService());
		return "list";
	}
	
	@RequestMapping("/insert")
	private String boardInsertForm() {
		return "insert";
	}
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request) throws Exception{
		
		Place_infoVO place = new Place_infoVO();
		place.setPlace_id(request.getParameter("place_id"));
		place.setPlace_nm(request.getParameter("place_nm"));
		placeService.placeInsertService(place);
		
		return "redirect:/list";
	}

	@RequestMapping("/delete/{place_id}")
	private String placeDelete(@PathVariable String place_id) throws Exception{
		placeService.placeDeleteService(place_id);
		return "redirect:/list";
	}
	
	@RequestMapping("/detail/{place_id}")
	private String placeDetail(@PathVariable String place_id, Model model) throws Exception{
		model.addAttribute("detail", placeService.placeDetailService(place_id));
		return "detail";
		
	}
	
}
