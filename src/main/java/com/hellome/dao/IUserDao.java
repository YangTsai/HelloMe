package com.hellome.dao;

import org.apache.ibatis.annotations.Param;
import com.hellome.model.User;

public interface IUserDao {

	/**
	 * 检验手机号是否被注册
	 * 
	 * @param phoneNumber
	 * @return 执行结果条数
	 */
	public int selectByPhone(@Param("phoneNumber") String phoneNumber);

	/**
	 * 检验手机号是否被注册
	 * 
	 * @param phoneNumber
	 * @return 用户对象
	 */
	public User selectUserByPhone(@Param("phoneNumber") String phoneNumber);
	
	/**
	 * 添加用户（注册）
	 * 
	 * @param user
	 * @return 执行结果条数
	 */
	public int insertUser(User user);

	/**
	 * 用户登录
	 * 
	 * @param phoneNum
	 * @param password
	 * @return
	 */
	public User selectUserLogin(@Param("phoneNumber") String phoneNumber, @Param("password") String password);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteById(@Param("id")String id);

	/**
	 * 获取用户信息
	 * @param id = 用户Id
	 * @return
	 */
	User selectById(@Param("id") String id);

	/**
	 * 更新用户信息
	 * @param record
	 * @return
	 */
	int updateById(User user);
	
	
}





