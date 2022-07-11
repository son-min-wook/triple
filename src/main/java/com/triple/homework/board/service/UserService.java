package com.triple.homework.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.triple.homework.board.domain.Place_infoVO;
import com.triple.homework.board.domain.User_infoVO;
import com.triple.homework.board.mapper.PlaceMapper;
import com.triple.homework.board.mapper.UserMapper;

@Service("com.triple.homework.board.service.UserService")
public class UserService {

	@Resource(name = "com.triple.homework.board.mapper.UserMapper")
	UserMapper userMapper;

	// 유저 체크
	public String userCheckService(String user_id) throws Exception {
		return userMapper.userCheck(user_id);
	}

	// 유저 생성
	public int userInsertService(User_infoVO users) throws Exception {
		return userMapper.userInsert(users);
	}

	// 유저 포인트 수정
	public int userUpdateService(User_infoVO users) throws Exception {
		return userMapper.userUpdate(users);
	}

	// 유저 포인트 수정
	public Integer userPointService(String user_id) throws Exception {
		return userMapper.userPoint(user_id);
	}
	
	//유저 목록
	public List<User_infoVO> userListService() throws Exception{
		return userMapper.userList();
	}

}
