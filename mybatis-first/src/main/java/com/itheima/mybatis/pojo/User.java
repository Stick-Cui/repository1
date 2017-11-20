package com.itheima.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private Integer id; // int(11) NOT NULL AUTO_INCREMENT,
	private String username; // varchar(32) NOT NULL COMMENT '用户名称',
	private Date birthday; // date DEFAULT NULL COMMENT '生日',
	private String sex; // char(1) DEFAULT NULL COMMENT '性别',
	private String address; // varchar(256) DEFAULT NULL COMMENT '地址',
	/**
	 * @return the id
	 */
	public Integer getId() {
	     return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
	     this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
	     return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
	     this.username = username;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
	     return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
	     this.birthday = birthday;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
	     return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
	     this.sex = sex;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
	     return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
	     this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	     return"User [id=" + id + ", username=" + username + ", birthday="
	             + birthday + ", sex=" + sex + ", address=" + address + "]";
	}
	
}
