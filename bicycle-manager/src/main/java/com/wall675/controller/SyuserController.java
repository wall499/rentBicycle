package com.wall675.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wall675.model.Syuser;
import com.wall675.service.SyuserService;

@Controller
public class SyuserController {
	@Autowired
	private SyuserService syuserServiceImpl;
	
	
	@RequestMapping("/login")
	@ResponseBody
	public Syuser login(@Validated Syuser syuser,BindingResult br, HttpSession session) {
		//如果验证不合法 直接返回
		if(br.hasErrors()) {
			return null;
		}
		
		Syuser user = syuserServiceImpl.login(syuser);
		if(user != null) {
			session.setAttribute("syuser", user);
		}
		return user;
	}
	
	//用户退出注销,重定向到登录页面
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//用户退出注销
		//session.removeAttribute("syuser");//销毁单个session的属性
		session.invalidate();//销毁session里的所有属性
		return "redirect:/index.html";
	}
	

}
