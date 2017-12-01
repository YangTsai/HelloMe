package com.hellome.dao;

import org.apache.ibatis.annotations.Param;
import com.hellome.model.User;

public interface IUserDao {

	/**
	 * 通过Id获取用户信息
	 * 
	 * @param 用户Id
	 * @return 用户对象
	 */
	public User selectUserById(@Param("id") String id);

	/**
	 * 通过手机号获取用户信息
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
	 * 通过Id删除用户
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(@Param("id") String id);

	/**
	 * 通过Id更新用户信息
	 * 
	 * @param user更新的用户对象信息
	 * @return
	 */
	public int updateById(User user);

}
