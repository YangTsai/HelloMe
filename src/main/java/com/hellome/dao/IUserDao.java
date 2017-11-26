package com.hellome.dao;

import com.hellome.model.User;

public interface IUserDao {	
	/**
	 * 添加用户 
	 * @param user
	 */
    public void addUser(User user);  
	
    int deleteByPrimaryKey(String userId);

    User selectByPrimaryKey
    (String id);

    int updateByPrimaryKey(User record);
}