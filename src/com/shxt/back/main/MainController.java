package com.shxt.back.main;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shxt.back.user.model.User;
import com.shxt.back.user.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	@RequestMapping("/back/main")
	public String main(){
		return "jsp/back/main/main";
	}
	@RequestMapping("/back/login")
	public String login(){
		return "jsp/back/main/login";
	}
	@RequestMapping("/back/loginDo")
	public String loginDo(User user,HttpServletRequest request,Map<String,Object> map){
		userService.login(user, map, request);
		return "jsp/back/main/"+map.get("url");
	}
}
