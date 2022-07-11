package com.triple.homework.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.triple.homework.board.domain.Place_infoVO;
import com.triple.homework.board.domain.Review_dtlVO;
import com.triple.homework.board.domain.Review_mstVO;

import com.triple.homework.board.domain.Review_mstVO;
import com.triple.homework.board.domain.Review_dtlVO;
import com.triple.homework.board.mapper.Review_mstMapper;
import com.triple.homework.board.mapper.PlaceMapper;
import com.triple.homework.board.mapper.Review_dtlMapper;

@Service("com.triple.homework.board.service.Review_mstService")
public class Review_mstService {
	
	@Resource(name="com.triple.homework.board.mapper.Review_mstMapper")
	Review_mstMapper review_mstMapper;
	
	public List<Review_mstVO> review_mstListService(String review_id) throws Exception{
		return review_mstMapper.review_mstList(review_id);
	}
	
	public List<Review_mstVO> review_byplaceListService(String place_id) throws Exception{
		return review_mstMapper.review_byplaceList(place_id);
	}
	
	public String review_mstContentService(String review_id) throws Exception{
		return review_mstMapper.review_mstContent(review_id);
	}
	
	public int review_mstInsertService(Review_mstVO review) throws Exception{
		return review_mstMapper.review_mstInsert(review);
	}
	
	public int review_mstUpdateService(Review_mstVO review) throws Exception{
		return review_mstMapper.review_mstUpdate(review);
	}
	
	public int review_mstDeleteService(String review) throws Exception{
		return review_mstMapper.review_mstDelete(review);
	}
}
