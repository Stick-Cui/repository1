package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;

public interface UserMapper {

	//
	User queryUserById(int id);
	
	//新增用户
	void insertUser(User user);
	
}
