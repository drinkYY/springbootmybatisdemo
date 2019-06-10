package com.example.springbootMybatisdemo2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootMybatisdemo2.entity.User;
import com.example.springbootMybatisdemo2.listener.MyListener;
import com.example.springbootMybatisdemo2.service.UserService;



@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/asd/{name}")
	public String asDouble(@PathVariable String name) {
		System.out.println("inter asDouble");
		System.out.println("***************** name == " + name);
		return "success";
	}
	/**
	 * 跳转到登录页
	 * @return
	 */
	@RequestMapping(value="/login")
	public String dologin(){
		return "login";
	}
	/**
	 * 跳转到注册页
	 * @return
	 */
	@RequestMapping(value="/register")
	public String doregister(){
		return "register";
	}
	
	@RequestMapping(value = "/index")
	@ResponseBody
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("fdf", "fdf");
		return "success";
	}
	
	@RequestMapping(value ="/online")
	@ResponseBody
	public Object online() {
		return "当前在线人数：" + MyListener.online;
	}

	/**
	 * 注册校验
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/doregister",method = RequestMethod.POST)
	public String register(User user, Model model){
		System.out.println("user:" + user);
		
		int num = userService.insertSelective(user) ;
		System.out.println(num);
		if(num == 0){
			model.addAttribute("msg", "注册失败！！");
			return "fail";
		}else {
			return "login";
		}
	}
	/**
	 * 登录校验
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/dologin",method = RequestMethod.POST)
	public String login(User user, Model model){
		System.out.println("user:" + user);
		User user1 = userService.selectUser(user) ;
		System.out.println(user1);
		if(user1 == null){
			model.addAttribute("msg", "用户名或者密码错误！！");
			return "fail";
		}else {
			model.addAttribute("msg", "登录成功！！！");
			return "success";
		}
	
		
	}
	
}
