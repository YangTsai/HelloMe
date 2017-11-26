package com.hellome.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hellome.model.User;
import com.hellome.service.IUserService;

/**
 * 
 * @author ASUS
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)

	public String regist(User user) {

		System.out.println("用户注册：" + user.getUserName() + user.getPassword());
		userService.regist(user);
		// 注册成功后跳转success.jsp页面
		return "success";
	}

	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public User toIndex(@RequestParam("id") String id, Model model) {
		User user = this.userService.getUserById(id);
		model.addAttribute("user", user);
		return user;
	}

}
