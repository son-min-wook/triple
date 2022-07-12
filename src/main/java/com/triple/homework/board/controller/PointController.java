package com.triple.homework.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.triple.homework.board.service.UserService;

@Controller
public class PointController {
	
	@Resource(name="com.triple.homework.board.service.UserService")
	UserService userService;
	
	@RequestMapping("/point") //게시판 리스트 화면 호출
	private String userList(Model model) throws Exception{
		model.addAttribute("point", userService.userListService());
		return "point";
	}

}
