package com.itheima.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class MybatisTest {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws Exception{
		//1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//.创建SqlSessionFactory
		sqlSessionFactory = builder.build(inputStream);
	}
		
	
	@Test
	public void queryUserById() throws Exception {
		
		//1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//.创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		//3.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//
		Object user = sqlSession.selectOne("user.queryUserById",24);
		//
		System.out.println(user);
		
	}

	@Test
	public void queryUserByName() throws Exception {
		
		//1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//.创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		//3.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//
		List<Object> users = sqlSession.selectList("user.queryUserByName","小明");
		//
		for (Object o : users) {
			System.out.println(o);
		}
		
	}
	
	@Test
	public void insertUser() throws Exception {
		
		//1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//.创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		//3.
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建user对象
		User user = new User();
		//
		//user.setId(4);
	    user.setUsername("苍井空");
	    user.setBirthday(new Date());
	    user.setSex("2");
	    user.setAddress("日本");
		//
		sqlSession.selectList("user.insertUserTwo",user);
		
		//数据库提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
	
	@Test
	public void updateUserByIdTest() {
		
		//1.创建sqlSession对象
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		
		//创建user对象
		User user = new User();
		//
		user.setId(3);
		user.setUsername("林诗音和小李飞刀");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("古龙小说");
		//
		sqlSession.update("user.updateUserById",user);
		
		//数据库提交事务
		//sqlSession.commit();
		//释放资源
		sqlSession.close();
	}
	
	
	
	
	
	
	
}
