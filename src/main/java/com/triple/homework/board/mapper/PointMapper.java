package com.triple.homework.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.triple.homework.board.domain.Point_hstVO;

@Repository("com.triple.homework.board.mapper.PointMapper")
public interface PointMapper {

	//이력 조회
	public Point_hstVO pointDetail(String user_id) throws Exception;

	//이력 저장
	public int pointInsert(Point_hstVO point) throws Exception;
	
	//시퀀스 조회
	public Integer pointSeq(String user_id) throws Exception;

}
