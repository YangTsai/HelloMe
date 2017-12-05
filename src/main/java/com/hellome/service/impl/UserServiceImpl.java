package com.hellome.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellome.constant.Constant;
import com.hellome.constant.ConstantStr;
import com.hellome.dao.IUserDao;
import com.hellome.model.JsonModel;
import com.hellome.model.User;
import com.hellome.service.IUserService;
import com.hellome.util.UUIDUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	public JsonModel getUserById(String id) {
		// TODO Auto-generated method stub
		JsonModel model = new JsonModel();
		User user = userDao.selectUserById(id);
		if (user != null) {
			model.setResult(true);
			model.setMsg(ConstantStr.user_info_success);
			user.setHeadUrl(Constant.HEAD_PATH + user.getHeadUrl());
			model.setData(user);
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_info_fail);
			model.setData(null);
		}
		return model;
	}

	@Override
	public JsonModel regist(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		JsonModel model = new JsonModel();
		// 检查手机号是否被注册
		User user = userDao.selectUserByPhone(phoneNumber);
		if (user == null) {
			user = new User();
			user.setId(UUIDUtil.getUUid());
			// 默认添加手机号为用户名
			user.setUserName(phoneNumber);
			user.setPhoneNumber(phoneNumber);
			user.setPassword(password);
			user.setCreateDate(user.getCreateDate());
//			user.setCreateDate(new Date());
//			user.setUpdateDate(new Date());
			// 添加用户数据
			int insertCount = userDao.insertUser(user);
			if (insertCount > 0) {
				model.setMsg(ConstantStr.add_success);
				model.setResult(true);
			} else {
				model.setResult(false);
				model.setMsg(ConstantStr.add_fail);
			}
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.add_successed);
		}
		return model;
	}

	@Override
	public JsonModel login(String phoneNumber, String password) {
		JsonModel model = new JsonModel();
		User user = userDao.selectUserByPhone(phoneNumber);
		if (user == null) {
			model.setResult(false);
			model.setMsg(ConstantStr.user_no_register);
		} else {
			if (!password.equals(user.getPassword())) {
				model.setResult(false);
				model.setMsg(ConstantStr.pwd_error);
			} else {
				model.setResult(true);
				model.setMsg(ConstantStr.login_success);
				model.setData(user);
			}

		}
		return model;
	}

	@Override
	public JsonModel updatePwd(String phoneNumber, String password) {
		// TODO Auto-generated method stub
		JsonModel model = new JsonModel();
		User user = userDao.selectUserByPhone(phoneNumber);
		if (user != null) {
			user.setPassword(password);
			int updateCount = userDao.updateById(user);
			if (updateCount > 0) {
				model.setResult(true);
				model.setMsg(ConstantStr.update_pwd_success);
				model.setData(user);
			} else {
				model.setResult(false);
				model.setMsg(ConstantStr.update_pwd_fail);
				model.setData(user);
			}
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_no_register);
		}
		return model;
	}

}
