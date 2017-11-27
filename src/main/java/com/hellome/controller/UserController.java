package com.hellome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hellome.model.JsonModel;
import com.hellome.model.User;
import com.hellome.service.IUserService;
import com.hellome.util.UUIDUtil;

/**
 * 
 * @description 用户相关controller
 * @author hyy
 * @date 2017年11月27日
 */

@Controller
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
	public @ResponseBody JsonModel regist(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "password") String password) throws Exception{
		User user = new User();
		user.setId(UUIDUtil.getUUid());
		user.setUserName(phoneNumber);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(password);
		return userService.regist(user);
	}

	/**
	 * 用户登录
	 * @param phoneNumber
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody JsonModel login(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "password") String password) throws Exception{
		return userService.login(phoneNumber, password);
	}
	
	/**
	 * 获取用户信息
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public @ResponseBody JsonModel getUser(@RequestParam("id") String id, Model model) {
		return userService.getUserById(id);
	}

}
