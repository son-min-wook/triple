package com.triple.homework.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.triple.homework.board.domain.Review_dtlVO;

@Repository("com.triple.homework.board.mapper.Review_dtlMapper")
public interface Review_dtlMapper {
	
	public Integer review_dtlCount() throws Exception;
	
	public Integer imgSeq(String review_id) throws Exception;
	
	//id만으로 조회
	public List<String> review_dtlList(String review_id) throws Exception;
	
	//id,sq로 조회
	public List<Review_dtlVO> review_dtlsqList(Review_dtlVO review) throws Exception;
	
	public int review_dtlInsert(Review_dtlVO review)throws Exception;
	
	public int review_dtlUpdate(Review_dtlVO review) throws Exception;
	
	//리뷰id로 삭제
	public int review_dtlDelete(String review_id) throws Exception;
	
	//리뷰id, img id로 삭제
	public int review_dtlsqDelete(Review_dtlVO review) throws Exception;
	
}
