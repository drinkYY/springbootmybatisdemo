package com.example.springbootMybatisdemo2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.springbootMybatisdemo2.service.UserService;

public class LoginFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// TODO Auto-generated method stub
		System.out.println("inter LoginFilter");
		HttpServletRequest htsr = (HttpServletRequest)request;
		HttpServletResponseWrapper hsrw = new HttpServletResponseWrapper((HttpServletResponse)response);
		
		if(htsr.getRequestURI().indexOf("/user/login") != -1||
				htsr.getRequestURI().indexOf("/user/register") != -1||
				htsr.getRequestURI().indexOf("/user/doregister") != -1||
				htsr.getRequestURI().indexOf("/user/dologin") != -1||
				htsr.getRequestURI().indexOf("/user/index") != -1||
				htsr.getRequestURI().indexOf("/user/online") != -1||
				htsr.getRequestURI().indexOf("/user/fail") != -1||
				htsr.getRequestURI().indexOf("/user/asd") != -1
				) {
			chain.doFilter(request, response);
		}else {
			System.out.println("重定向到login");
			hsrw.sendRedirect("/user/login");
		}
		
		
		
	}

}
