package com.triple.homework.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.triple.homework.board.domain.Place_infoVO;

@Repository("com.triple.homework.board.mapper.PlaceMapper")
public interface PlaceMapper {

		//장소 개수
		public Integer placeCount() throws Exception;
		
		//장소 목록
		public List<Place_infoVO> placeList() throws Exception;
		
		//장소 상세
		public Place_infoVO placeDetail(String place_id) throws Exception;
		
		//장소 작성
		public int placeInsert(Place_infoVO place) throws Exception;
		
		//장소 삭제
		public int placeDelete(String place_id) throws Exception;
		
		//장소 수정
		public int placeUpdate(Place_infoVO place_info) throws Exception;
		
		//첫 댓글작성자
		public String first_reviewer(String place_id) throws Exception;
		

		
		
}
