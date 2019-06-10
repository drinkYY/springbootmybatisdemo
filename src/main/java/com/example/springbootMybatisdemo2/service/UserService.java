package com.example.springbootMybatisdemo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootMybatisdemo2.entity.User;
import com.example.springbootMybatisdemo2.mapper.UserMapper;



@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	public User selectUser(User user){
		return  userMapper.selectUser(user.getUserName(), user.getPassword());
	}

	public int insertSelective(User user){
		return  userMapper.insertSelective(user);
	}
}
