package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;

public interface UserDao {

	//
	User queryUserById(int id);
	
	//新增用户
	void insertUser(User user);
	
}
