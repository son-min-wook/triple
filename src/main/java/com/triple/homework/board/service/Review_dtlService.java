package com.triple.homework.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.triple.homework.board.domain.Review_dtlVO;
import com.triple.homework.board.domain.Review_mstVO;
import com.triple.homework.board.mapper.Review_dtlMapper;

@Service("com.triple.homework.board.service.Review_dtlService")
public class Review_dtlService {
	
	@Resource(name="com.triple.homework.board.mapper.Review_dtlMapper")
	Review_dtlMapper review_dtlMapper;
	
	public Integer review_dtlCountService() throws Exception{
		return review_dtlMapper.review_dtlCount();
	}
	
	public Integer imgSeqService(String review_id) throws Exception{
		return review_dtlMapper.imgSeq(review_id);
	}
	
	//id만으로 조회
	public List<String> review_dtlListService(String review_id) throws Exception{
		return review_dtlMapper.review_dtlList(review_id);
	}
	
	//id,sq로 조회
	public List<Review_dtlVO> review_dtlsqListService(Review_dtlVO review_id) throws Exception{
		return review_dtlMapper.review_dtlsqList(review_id);
	}
	
	public int review_dtlInsertService(Review_dtlVO review) throws Exception{
		return review_dtlMapper.review_dtlInsert(review);
	}
	
	public int review_dtlUpdateService(Review_dtlVO review) throws Exception{
		return review_dtlMapper.review_dtlUpdate(review);
	}
	
	//id전체삭제
	public int review_dtlDeleteService(String review) throws Exception{
		return review_dtlMapper.review_dtlDelete(review);
	}
	
	//id,sq삭제
	public int review_dtlsqDeleteService(Review_dtlVO review) throws Exception{
		return review_dtlMapper.review_dtlsqDelete(review);
	}
	

}
