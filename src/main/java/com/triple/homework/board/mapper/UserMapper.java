package com.triple.homework.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.triple.homework.board.domain.Place_infoVO;
import com.triple.homework.board.domain.User_infoVO;

@Repository("com.triple.homework.board.mapper.UserMapper")
public interface UserMapper {


	//유저 추가
	public String userCheck(String user_id) throws Exception;
		
	//유저 추가
	public int userInsert(User_infoVO users) throws Exception;

	//유저 삭제
	public int userDelete(String user_id) throws Exception;

	//유저 수정
	public int userUpdate(User_infoVO users) throws Exception;
	
	//포인트 조회
	public Integer userPoint(String user_id) throws Exception;
	
	//포인트 조회
	public List<User_infoVO> userList() throws Exception;
	
}