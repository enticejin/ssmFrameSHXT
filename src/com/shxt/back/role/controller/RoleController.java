package com.shxt.back.role.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shxt.back.main.PageBean;
import com.shxt.back.role.model.Role;
import com.shxt.back.role.service.RoleService;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	@RequestMapping("/back/roleList")
	public String roleList(Role role,Map<String,Object> map,@RequestParam(required=false,defaultValue="1") int pages,@RequestParam(required=false,defaultValue="5")int num,HttpServletRequest request){
		PageBean.conMap(pages, map, num, request, role);
		roleService.roleList(map);
		return "jsp/back/role/roleList";
	}
	@RequestMapping("/back/roleAdd")
	public String roleList(){
		return "jsp/back/role/roleAdd";
	}
	@RequestMapping("/back/roleAddDo")
	public String roleAddDo(Role role,Map<String,Object> map){
		map.put("role", role);
		roleService.roleAdd(map, role);
		return "jsp/back/main/message";
	}
	@RequestMapping("/back/roleMdi")
	public String roleMdi(Integer role_id,Map< String, Object> map){
		Role role = roleService.load(role_id);
		map.put("role", role);
		return "jsp/back/role/roleMdi";
	}
	@RequestMapping("/back/roleMdiDo")
	public String roleMdiDo(Role role,Map<String,Object> map) {
		map.put("role", role);
		roleService.roleMdi(map, role);
		return "jsp/back/main/message";
	}
	@RequestMapping("/back/roleDel")
	public String roleDel(Integer role_id,Map< String, Object> map){
		map.put("role_id", role_id);
		return "jsp/back/role/roleDel";
	}
	@RequestMapping("/back/roleDelDo")
	public String roleDelDo(Integer role_id,Map< String, Object> map){
		roleService.roleDel(map, role_id);
		return "jsp/back/main/message";
	}
	@RequestMapping("/back/menuMdi")
	public String menuMdi(Integer role_id,Map< String, Object> map){
		roleService.menuMdi(map, role_id);
		map.put("role_id", role_id);
		return "jsp/back/role/menuMdi";
	}
	@RequestMapping("/back/menuMdiDo")
	public String menuMdiDo(Integer role_id,Map< String, Object> map,Integer[] selectR){
		map.put("role_id", role_id);
		map.put("selectR", selectR);
		roleService.menuMdiDo(map);
		return "jsp/back/main/message";
	}
}
