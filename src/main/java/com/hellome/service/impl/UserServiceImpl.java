package com.hellome.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hellome.dao.IUserDao;
import com.hellome.model.User;
import com.hellome.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(id);
	}

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		 userDao.addUser(user);  
	}

}
