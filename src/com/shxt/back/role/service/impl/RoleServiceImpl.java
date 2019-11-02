package com.shxt.back.role.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.back.main.PageBean;
import com.shxt.back.menu.mapper.MenuMapper;
import com.shxt.back.menu.model.Menu;
import com.shxt.back.rlm.mapper.RlmMapper;
import com.shxt.back.rlm.model.Rlm;
import com.shxt.back.role.mapper.RoleMapper;
import com.shxt.back.role.model.Role;
import com.shxt.back.role.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RlmMapper rlmMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}
	@Override
	public Map<String, Object> roleList(Map<String, Object> map) {
		List<Role> roleList = roleMapper.roleList(map);
		int count = roleMapper.count(map);
		PageBean.serMap(map, count, roleList, Role.class);
		return map;
	}
	@Override
	public Map<String, Object> roleAdd(Map<String, Object> map, Role role) {
		int result = roleMapper.add(role);
		if(result>0){
			map.put("message", "添加成功");
		}else {
			map.put("message", "添加失败");
		}
		return map;
	}
	@Override
	public Role load(int role_id) {
		return roleMapper.load(role_id);
	}
	@Override
	public Map<String, Object> roleMdi(Map<String, Object> map, Role role) {
		int result = roleMapper.update(role);
		if(result>0){
			map.put("message", "修改成功");
		}else {
			map.put("message", "修改失败");
		}
		return map;
	}
	@Override
	public Map<String, Object> roleDel(Map<String, Object> map, int role_id) {
		int result = roleMapper.delete(role_id);
		if(result>0){
			map.put("message", "删除成功");
		}else {
			map.put("message", "删除失败");
		}
		return map;
	}
	@Override
	public List<Role> roleAllList() {
		return roleMapper.roleAllList();
	}
	@Override
	public Map<String, Object> menuMdi(Map<String, Object> map, int role_id) {
		List<Rlm> havList = rlmMapper.havList(role_id);
		List<Menu> noList = menuMapper.noList(role_id);
		map.put("havList", havList);
		map.put("noList", noList);
		return map;
	}
	@Override
	public Map<String, Object> menuMdiDo(Map<String, Object> map) {
		rlmMapper.delMenu(map);
		Integer[] selectR = (Integer[])map.get("selectR");
		if(selectR!=null&&selectR.length>0){
			rlmMapper.addMenu(map);
		}
		map.put("message", "分配成功");
		return map;
	}

}
