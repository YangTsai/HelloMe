package com.hellome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hellome.constant.ConstantStr;
import com.hellome.dao.IUserDao;
import com.hellome.model.JsonModel;
import com.hellome.model.User;
import com.hellome.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	public JsonModel getUserById(String id) {
		// TODO Auto-generated method stub
		JsonModel model = new JsonModel();
		User user = userDao.selectByPrimaryKey(id);
		if(user != null) {
			model.setResult(true);
			model.setMsg(ConstantStr.user_info_success);
			model.setData(user);
		}else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_info_fail);
			model.setData(null);
		}
		return model;
	}

	@Override
	public JsonModel regist(User user) {
		// TODO Auto-generated method stub
		JsonModel model = new JsonModel();
		boolean result = userDao.addUser(user);
		model.setResult(result);
		if (result) {
			model.setMsg(ConstantStr.add_success);
		} else {
			model.setMsg(ConstantStr.add_fail);
		}
		model.setData(null);
		return model;
	}

	@Override
	public JsonModel login(String phoneNumber, String password) {
		JsonModel model = new JsonModel();
		User user = userDao.findUserByLogin(phoneNumber, password);
		if(user != null) {
			model.setResult(true);
			model.setMsg(ConstantStr.login_success);
			model.setData(user);
		}else {
			model.setResult(false);
			model.setMsg(ConstantStr.login_fail);
			model.setData(null);
		}
		return model;
	}

}
