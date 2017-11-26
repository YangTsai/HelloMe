package com.hellome.service;

import com.hellome.model.User;

public interface IUserService {
	
	
	//用户注册  
	public void regist(User user);  
	/**
	 * ����Id��ȡ����
	 * @param userId
	 * @return
	 */
	public User getUserById(String userId);
	

}
