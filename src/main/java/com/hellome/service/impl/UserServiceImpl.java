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

	public User getUserById(String id) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByPrimaryKey(id);
		return user;
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
			int count = userMapper.insert(user);
			if (count > 0) {
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
	public User login(String phoneNumber, String password) {
		User user = null;
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneNumberEqualTo(phoneNumber);
		criteria.andPasswordEqualTo(password);
		List<User> list = userMapper.selectByExample(example);
		if (list == null || list.size() == 0) {
			user = list.get(0);
		}
		return user;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		int count = 0;
		if (user.getId() != null) {
			// 更新用户其他信息
			count = userMapper.updateByPrimaryKeySelective(user);
		} else if (user.getPhoneNumber() != null) {
			// 更新用户密码
			String phoneNumber = user.getPhoneNumber();
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andPhoneNumberEqualTo(phoneNumber);
			count = userMapper.updateByExampleSelective(user, example);
		}
		return count;
	}
}
