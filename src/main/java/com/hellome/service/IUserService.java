package com.hellome.service;

import com.hellome.pojo.JsonModel;

/**
 * 用户服务层
 * 
 * @description
 * @author hyy
 * @date 2017年11月27日
 */

public interface IUserService {

	/**
	 * 检测手机号是否注册
	 * 
	 * @param phoneNumber
	 * @return 是否注册
	 */
	public boolean checkPhoneNumber(String phoneNumber);

	/**
	 * 用户注册
	 * 
	 * @param phoneNumber手机号
	 * @param password密码（加密之后）
	 * @return
	 */
	public JsonModel regist(String phoneNumber, String password);

	/**
	 * 用户登录
	 * 
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

	/**
	 * 更新用户密码
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public JsonModel updatePwd(String phoneNumber, String password);

}
