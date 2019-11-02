package com.shxt.back.user.cocntroller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shxt.back.main.PageBean;
import com.shxt.back.role.service.RoleService;
import com.shxt.back.user.model.User;
import com.shxt.back.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	RoleService roleService;
	@RequestMapping("/back/userList")
	public String userList(User user,Map<String,Object> map,@RequestParam(required=false,defaultValue="1") int pages,@RequestParam(required=false,defaultValue="5")int num,HttpServletRequest request){
		PageBean.conMap(pages, map, num, request, user);
		userService.userList(map);
		return "jsp/back/user/userList";
	}
	@RequestMapping("/back/userAdd")
	public String userAdd(Map<String, Object> map){
		map.put("roleAllList", roleService.roleAllList());
		return "jsp/back/user/userAdd";
	}
	@RequestMapping("/back/userAddDo")
	public String userAddDo(User user,Map<String,Object> map,MultipartFile photo) throws IllegalStateException, IOException{
		if(photo!=null&&photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){
			String path = "C:\\workspace\\yf13\\ssm\\WebContent\\upload";
			String realName = photo.getOriginalFilename();
			String ext = FilenameUtils.getExtension(realName);
			String newName = UUID.randomUUID().toString().replaceAll("-", "")+"."+ext;
			File file = new File(path+"/"+newName);
			photo.transferTo(file);
			user.setUser_img(newName);
		}
		map.put("user", user);
		userService.userAdd(map, user);
		return "jsp/back/main/message";
	}
	@RequestMapping("/back/userMdi")
	public String userMdi(int user_id,Map< String, Object> map){
		User user = userService.load(user_id);
		map.put("user", user);
		map.put("roleAllList", roleService.roleAllList());
		return "jsp/back/user/userMdi";
	}
	@RequestMapping("/back/userMdiDo")
	public String userMdiDo(User user,Map<String,Object> map,MultipartFile photo) throws IllegalStateException, IOException{
		if(photo!=null&&photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){
			String path = "C:\\workspace\\yf13\\ssm\\WebContent\\upload";
			String realName = photo.getOriginalFilename();
			String ext = FilenameUtils.getExtension(realName);
			String newName = UUID.randomUUID().toString().replaceAll("-", "")+"."+ext;
			File file = new File(path+"/"+newName);
			photo.transferTo(file);
			user.setUser_img(newName);
		}
		map.put("user", user);
		userService.userMdi(map, user);
		return "jsp/back/main/message";
	}
	@RequestMapping("/back/userDel")
	public String userDel(int user_id,Map< String, Object> map){
		map.put("user_id", user_id);
		return "jsp/back/user/userDel";
	}
	@RequestMapping("/back/userDelDo")
	public String userDelDo(int user_id,Map< String, Object> map){
		userService.userDel(map, user_id);
		return "jsp/back/main/message";
	}
}
