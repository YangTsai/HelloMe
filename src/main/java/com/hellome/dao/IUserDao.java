package com.hellome.dao;

import org.apache.ibatis.annotations.Param;

import com.hellome.model.User;

public interface IUserDao {

	/**
	 * 添加用户（注册）
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);

	/**
	 * 用户登录
	 * 
	 * @param phoneNum
	 * @param password
	 * @return
	 */
	public User findUserByLogin(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

	int deleteByPrimaryKey(String userId);

	User selectByPrimaryKey(String id);

	int updateByPrimaryKey(User record);
}