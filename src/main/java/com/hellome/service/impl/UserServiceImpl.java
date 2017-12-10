package com.hellome.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellome.constant.Constant;
import com.hellome.constant.ConstantStr;
import com.hellome.dao.UserMapper;
import com.hellome.pojo.JsonModel;
import com.hellome.pojo.User;
import com.hellome.pojo.UserExample;
import com.hellome.pojo.UserExample.Criteria;
import com.hellome.service.IUserService;
import com.hellome.util.UUIDUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean checkPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneNumberEqualTo(phoneNumber);
		List<User> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public JsonModel getUserById(String id) {
		// TODO Auto-generated method stub
		JsonModel model = new JsonModel();
		User user = userMapper.selectByPrimaryKey(id);
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
		if (!checkPhoneNumber(phoneNumber)) {
			User user = new User();
			user.setId(UUIDUtil.getUUid());
			// 默认添加手机号为用户名
			user.setUserName(phoneNumber);
			user.setPhoneNumber(phoneNumber);
			user.setPassword(password);
			user.setCreateDate(new Date());
			user.setUpdateDate(new Date());
			// 添加用户数据
			int insertCount = userMapper.insert(user);
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
		if (checkPhoneNumber(phoneNumber)) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andPhoneNumberEqualTo(phoneNumber);
			criteria.andPasswordEqualTo(password);
			List<User> list = userMapper.selectByExample(example);
			if (list == null || list.size() == 0) {
				model.setResult(false);
				model.setMsg(ConstantStr.pwd_error);
			} else {
				model.setResult(true);
				model.setMsg(ConstantStr.login_success);
				model.setData(list.get(0));
			}
		} else {
			model.setResult(false);
			model.setMsg(ConstantStr.user_no_register);
		}
		return model;
	}

	@Override
	public JsonModel updateUser(User user) {
		// TODO Auto-generated method stub
		JsonModel model = new JsonModel();
		if (user == null) {
			return model;
		} else if (user.getId() != null) {
			// 更新用户其他信息
			int count = userMapper.updateByPrimaryKeySelective(user);
			if (count > 0) {
				model.setResult(true);
				model.setMsg(ConstantStr.update_pwd_success);
				model.setData(user);
			} else {
				model.setResult(false);
				model.setMsg(ConstantStr.update_pwd_fail);
				model.setData(user);
			}
		} else if (user.getPhoneNumber() != null) {
			// 更新用户密码
			String phoneNumber = user.getPhoneNumber();
			if (checkPhoneNumber(phoneNumber)) {
				UserExample example = new UserExample();
				Criteria criteria = example.createCriteria();
				criteria.andPhoneNumberEqualTo(phoneNumber);
				int count = userMapper.updateByExampleSelective(user, example);
				if (count > 0) {
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
		}
		return model;
	}

}
