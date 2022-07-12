package com.triple.homework.board.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.triple.homework.board.domain.Place_infoVO;
import com.triple.homework.board.mapper.PlaceMapper;

@Service("com.triple.homework.board.service.PlaceService")
public class PlaceService {

	@Resource(name="com.triple.homework.board.mapper.PlaceMapper")
	PlaceMapper placeMapper;
	
	//장소 목록
	public List<Place_infoVO> placeListService() throws Exception{
		return placeMapper.placeList();
	}
	
	//장소 상세
	public Place_infoVO placeDetailService(String place_id) throws Exception{
		return placeMapper.placeDetail(place_id);
	}
	
	//장소 작성
	@Transactional(rollbackFor = Exception.class)
	public int placeInsertService(Place_infoVO place) throws Exception{
		return placeMapper.placeInsert(place);
	}
	
	//장소 수정
	@Transactional(rollbackFor = Exception.class)
	public int placeUpdateService(Place_infoVO place) throws Exception{
		return placeMapper.placeUpdate(place);
	}
	
	//장소 삭제
	@Transactional(rollbackFor = Exception.class)
	public int placeDeleteService(String place_id) throws Exception{
		return placeMapper.placeDelete(place_id);
	}
	
	//첫 리뷰
	public String first_reviewerService(String place_id) throws Exception{
		return placeMapper.first_reviewer(place_id);
	}
}
