package com.shxt.back.role.service;

import java.util.List;
import java.util.Map;

import com.shxt.back.role.model.Role;

public interface RoleService {
	int update(Role role);
	Map<String, Object> roleList(Map<String, Object> map);
	Map<String, Object> roleAdd(Map<String, Object> map,Role role);
	Role load(int role_id);
	Map<String, Object> roleMdi(Map<String, Object> map,Role role);
	Map<String, Object> roleDel(Map<String, Object> map,int role_id);
	List<Role> roleAllList();
	Map<String, Object> menuMdi(Map<String, Object> map,int role_id);
	Map<String, Object> menuMdiDo(Map<String, Object> map);
}
