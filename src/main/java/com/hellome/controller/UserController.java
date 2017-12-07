package com.hellome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hellome.pojo.JsonModel;
import com.hellome.service.IUserService;

/**
 * 
 * @description 用户相关controller
 * @author hyy
 * @date 2017年11月27日
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 用户注册
	 * 
	 * @param phoneNumber手机号
	 * @param password密码
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JsonModel regist(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "password") String password) throws Exception {
		return userService.regist(phoneNumber, password);
	}

	/**
	 * 用户登录
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JsonModel login(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "password") String password) throws Exception {
		return userService.login(phoneNumber, password);
	}

	/**
	 * 获取用户信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public JsonModel getUser(@RequestParam("id") String id) {
		return userService.getUserById(id);
	}

	/**
	 * 更新用户密码
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	public JsonModel updatePwd(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "password") String password) {
		return userService.updatePwd(phoneNumber, password);
	}

}
