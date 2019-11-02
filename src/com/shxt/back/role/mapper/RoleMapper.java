/**
 * RoleMapper.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-06-12 14:43:16
 **/
package com.shxt.back.role.mapper;

import java.util.List;
import java.util.Map;

import com.shxt.back.role.model.Role;

public interface RoleMapper {
	 int delete(Integer role_id);
	    int add(Role role);
	    Role load(Integer role_id);
	    int update(Role role);
	    List<Role> roleList(Map<String, Object> map);
	    int count(Map<String, Object> map);
	    List<Role> roleAllList();
}