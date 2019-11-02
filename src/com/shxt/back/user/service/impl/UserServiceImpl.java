package com.shxt.back.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.back.main.PageBean;
import com.shxt.back.menu.mapper.MenuMapper;
import com.shxt.back.menu.model.Menu;
import com.shxt.back.rlm.mapper.RlmMapper;
import com.shxt.back.rlm.model.Rlm;
import com.shxt.back.user.mapper.UserMapper;
import com.shxt.back.user.model.User;
import com.shxt.back.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RlmMapper rlmMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Override
	public int update(User user) {
		return userMapper.update(user);
	}
	@Override
	public Map<String, Object> userList(Map<String, Object> map) {
		List<User> userList = userMapper.userList(map);
		int count = userMapper.count(map);
		PageBean.serMap(map, count, userList, User.class);
		return map;
	}
	@Override
	public Map<String, Object> userAdd(Map<String, Object> map, User user) {
		int result = userMapper.add(user);
		if(result>0){
			map.put("message", "添加成功");
		}else {
			map.put("message", "添加失败");
		}
		return map;
	}
	@Override
	public User load(int user_id) {
		return userMapper.load(user_id);
	}
	@Override
	public Map<String, Object> userMdi(Map<String, Object> map, User user) {
		int result = userMapper.update(user);
		if(result>0){
			map.put("message", "修改成功");
		}else {
			map.put("message", "修改失败");
		}
		return map;
	}
	@Override
	public Map<String, Object> userDel(Map<String, Object> map, int user_id) {
		int result = userMapper.delete(user_id);
		if(result>0){
			map.put("message", "删除成功");
		}else {
			map.put("message", "删除失败");
		}
		return map;
	}
	@Override
	public Map<String, Object> login(User user, Map<String, Object> map, HttpServletRequest request) {
		User u = userMapper.login(user);
		if(u!=null){
			map.put("url", "main");
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			System.out.println(u);
			List<Rlm> sonList = rlmMapper.havList(u.getFk_role_id());
			if(sonList.size()>0){
				List<Menu> fatherList = menuMapper.fatherList(u.getFk_role_id());
				session.setAttribute("sonList", sonList);
				session.setAttribute("fatherList", fatherList);
			}
		}else {
			map.put("message", "用户名或密码错误!");
			map.put("url", "login");
		}
		return map;
	}

}
