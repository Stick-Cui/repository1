package com.itheima.mybatis.test;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.impl.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

public class UserDaoTest {
	
	//
	private SqlSessionFactory sqlSessionFactory = null;
	
	//
	@Before
	public void init() throws Exception{
		//1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//.创建SqlSessionFactory
		sqlSessionFactory = builder.build(inputStream);
	}
	
	//
	@Test
	public void queryUserByIdTest(){
	    
	     // 1.创建用户dao对象
	     UserDao userDao = new UserDaoImpl(sqlSessionFactory);
	    
	     // 2.使用userDao对象，调用方法执行
	     User user = userDao.queryUserById(24);
	     
	     System.out.println(user);
	    
	}
	
	@Test
	public void insertUser(){
		
		// 1.创建用户dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		//
		User user = new User();
	    user.setUsername("阿飞");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("来自大明朝");
		
		// 2.使用userDao对象，调用方法执行
		userDao.insertUser(user);
		
	}
}
