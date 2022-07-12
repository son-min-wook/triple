package com.triple.homework.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.triple.homework.board.domain.ReviewVO;
import com.triple.homework.board.domain.Review_dtlVO;
import com.triple.homework.board.domain.Review_mstVO;

@Repository("com.triple.homework.board.mapper.ReviewMapper")
public interface ReviewMapper {
	
public int review_mstCount() throws Exception;
	
	public List<ReviewVO> review_byplaceList() throws Exception;

	public List<ReviewVO> reviewExist(String place_id, String user_id) throws Exception;
}
