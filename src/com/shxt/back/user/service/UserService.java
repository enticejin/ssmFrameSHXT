package com.shxt.back.user.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shxt.back.user.model.User;

public interface UserService {
	int update(User user);
	Map<String, Object> userList(Map<String, Object> map);
	Map<String, Object> userAdd(Map<String, Object> map,User user);
	User load(int user_id);
	Map<String, Object> userMdi(Map<String, Object> map,User user);
	Map<String, Object> userDel(Map<String, Object> map,int user_id);
	Map<String, Object> login(User user,Map<String, Object> map,HttpServletRequest request); 
}
