package com.example.springbootMybatisdemo2.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import com.example.springbootMybatisdemo2.entity.User;




public class LoginInterceptor implements HandlerInterceptor{


	public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = new User();
		System.out.println("inter  preHandle");
		String name = request.getParameter("userName");
		String uName = user.getUserName(); 
		System.out.println("MyInterceptor: " + name);
		if(name!=null&&name.equals(name)) {
			return true;
		}else {
			PrintWriter  printWriter = response.getWriter();
			printWriter.write("please login again!!");
			return false;
		}

	}
}
