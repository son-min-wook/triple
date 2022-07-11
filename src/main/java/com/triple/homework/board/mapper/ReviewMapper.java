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
	
	
	public List<Review_mstVO> review_mstList(String review_id) throws Exception;
	
	
	public int review_mstInsert(Review_mstVO review)throws Exception;
	
	public int review_mstUpdate(Review_mstVO review) throws Exception;
	
	public int review_mstDelete(String review_id) throws Exception;
	
	public int review_dtlCount() throws Exception;
	
	//id만으로 조회
	public List<Review_dtlVO> review_dtlList(String review_id) throws Exception;
	
	//id,sq로 조회
	public List<Review_dtlVO> review_dtlsqList(Review_dtlVO review) throws Exception;
	
	public int review_dtlInsert(Review_dtlVO review)throws Exception;
	
	public int review_dtlUpdate(Review_dtlVO review) throws Exception;
	
	//id전체삭제
	public int review_dtlDelete(String review_id) throws Exception;
	
	//id,sq삭제
	public int review_dtlsqDelete(Review_dtlVO review) throws Exception;

}
