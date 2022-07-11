package com.triple.homework.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.triple.homework.board.domain.Point_hstVO;
import com.triple.homework.board.mapper.PointMapper;

@Service("com.triple.homework.board.service.PointService")
public class PointService {
	
	@Resource(name="com.triple.homework.board.mapper.PointMapper")
	PointMapper pointMapper;
	
	//이력 조회
	public Point_hstVO pointDetailService(String user_id) throws Exception{
		return pointMapper.pointDetail(user_id);
	}
	
	//이력 저장
	public int pointInsertService(Point_hstVO point) throws Exception{
		return pointMapper.pointInsert(point);
	}
	
	//시퀀스 조회
	public Integer pointSeqService(String user_id) throws Exception{
		return pointMapper.pointSeq(user_id);
	}

}
