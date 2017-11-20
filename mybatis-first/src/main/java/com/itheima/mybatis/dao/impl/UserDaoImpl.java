package com.itheima.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {

	//定义SqlSession对象
	private SqlSessionFactory sqlSessionFactory;
	
	//构造方法
	public UserDaoImpl() {
		super();
	}
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}



	/**
	 * 
	 */
	public User queryUserById(int id) {
		//
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		//
		Object user = sqlSession.selectOne("user.queryUserById",id);
		//
		sqlSession.close();
		//
		return (User)user;
	}

	/**
	 * 
	 */
	public void insertUser(User user) {
		//
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		//
		sqlSession.insert("user.insertUserTwo",user);
		//
		sqlSession.close();
	}
	
	
	
	
	
	
}
