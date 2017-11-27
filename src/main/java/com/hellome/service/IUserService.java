package com.hellome.service;

import com.hellome.model.JsonModel;
import com.hellome.model.User;

/**
 * 用户服务层
 * 
 * @description
 * @author hyy
 * @date 2017年11月27日
 */

public interface IUserService {

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public JsonModel regist(User user);

	/**
	 * 用户登录
	 * @param phoneNumber
	 * @param password
	 * @return
	 */
	public JsonModel login(String phoneNumber, String password);

	/**
	 * 通过Id获取User对象
	 * 
	 * @param id
	 * @return
	 */
	public JsonModel getUserById(String id);

}
