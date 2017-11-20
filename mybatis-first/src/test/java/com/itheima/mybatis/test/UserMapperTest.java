package com.itheima.mybatis.test;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.dao.impl.UserDaoImpl;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;

public class UserMapperTest {
	
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
		 SqlSession sqlSession = sqlSessionFactory.openSession();
	     // 2.使用userDao对象，调用方法执行
		 UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		 //
		 User user = userMapper.queryUserById(24);
		 //
	     System.out.println(user);
	}
	
	@Test
	public void insertUser(){
		
	    // 1.创建用户dao对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
	    // 2.使用userDao对象，调用方法执行
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//
		User user = new User();
	    user.setUsername("孙悟空");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("来自西游记");
		
        
		// 2.使用userDao对象，调用方法执行
		userMapper.insertUser(user);
		sqlSession.commit();
		
		//
		sqlSession.close();
	}
}
