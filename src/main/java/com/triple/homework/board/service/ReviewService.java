package com.triple.homework.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.triple.homework.board.domain.ReviewVO;
import com.triple.homework.board.domain.Review_mstVO;
import com.triple.homework.board.mapper.ReviewMapper;
import com.triple.homework.board.mapper.Review_dtlMapper;
import com.triple.homework.board.mapper.Review_mstMapper;

@Service("com.triple.homework.board.service.ReviewService")
public class ReviewService {
	
	@Resource(name="com.triple.homework.board.mapper.ReviewMapper")
	ReviewMapper reviewMapper;
	@Resource(name="com.triple.homework.board.mapper.Review_mstMapper")
	Review_mstMapper review_mstMapper;
	@Resource(name="com.triple.homework.board.mapper.Review_dtlMapper")
	Review_dtlMapper review_dtlMapper;
	
	public List<ReviewVO> review_byplaceListService() throws Exception{
		return reviewMapper.review_byplaceList();
	}
	
	public List<ReviewVO> reviewExistService(String place_id,String user_id) throws Exception{
		return reviewMapper.reviewExist(place_id,user_id);
	}
}
