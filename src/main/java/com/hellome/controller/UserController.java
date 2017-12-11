package com.hellome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hellome.constant.Constant;
import com.hellome.constant.ConstantStr;
import com.hellome.pojo.JsonModel;
import com.hellome.pojo.User;
import com.hellome.pojo.UserExample;
import com.hellome.pojo.UserExample.Criteria;
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
		JsonModel model = new JsonModel();
		boolean result = userService.checkPhoneNumber(phoneNumber);
		if (result) {
			User user = userService.login(phoneNumber, password);
			if (user == null) {
				model.setResult(true);
				model.setMsg(ConstantStr.login_success);
				model.setData(user);
			} else {
				model.setData(user);
			}
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_no_register);
		}
		return model;
	}

	/**
	 * 获取用户信息
	 * 
	 * @parami
	 * @return
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public JsonModel getUser(@RequestParam("id") String id) {
		JsonModel model = new JsonModel();
		User user = userService.getUserById(id);
		if (user != null) {
			user.setHeadUrl(Constant.HEAD_PATH + user.getHeadUrl());
			model.setResult(true);
			model.setMsg(ConstantStr.user_info_success);
			model.setData(user);
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_info_fail);
			model.setData(null);
		}
		return model;
	}

	/**
	 * 更新用户信息
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public JsonModel updateUser(User user) {
		JsonModel model = new JsonModel();
		int count = userService.updateUser(user);
		
		
		return model;
	}

}
