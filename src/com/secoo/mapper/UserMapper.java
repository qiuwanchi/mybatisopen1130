package com.secoo.mapper;

import java.util.List;
import java.util.Map;

import com.secoo.entity.User;

public interface UserMapper {

	public User findUserById(int id);
	
	public List<User> findUserByUserName(String userName);
	
	public List<Map<String,String>> findUserByUserName2(String userName);
	
	public void updateUser(User user);
}
