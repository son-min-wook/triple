package com.triple.homework.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.triple.homework.board.domain.Review_mstVO;

@Repository("com.triple.homework.board.mapper.Review_mstMapper")
public interface Review_mstMapper {

	public Integer review_mstCount() throws Exception;
	
	public List<Review_mstVO> review_mstList(String review_id) throws Exception;
	
	public List<Review_mstVO> review_byplaceList(String place_id) throws Exception;
	
	public int review_mstInsert(Review_mstVO review)throws Exception;
	
	public int review_mstUpdate(Review_mstVO review) throws Exception;
	
	public int review_mstDelete(String review_id) throws Exception;
	
	public String review_mstContent(String review_id) throws Exception;
}
