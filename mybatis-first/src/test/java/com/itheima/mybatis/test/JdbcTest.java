package com.itheima.mybatis.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcTest {

	public static void main(String[] args) {
		
		//定义
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet set = null;
		
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.创建数据库连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");
			//3.定义sql
			String sql = "select * from user where id = ?";
			//4.创建statment语句对象
			psmt = conn.prepareStatement(sql);
			//5.设置参数
			psmt.setInt(1, 24);
			//6.执行
			set = psmt.executeQuery();
			//7.处理结果集
		    while(set.next()){
		    	System.out.println("用户id为"+set.getInt("id")+";用户名称为:"+set.getString("username"));
		    }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				set.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
