package com.example.springbootMybatisdemo2.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.springbootMybatisdemo2.filter.LoginFilter;
import com.example.springbootMybatisdemo2.interceptor.LoginInterceptor;
import com.example.springbootMybatisdemo2.listener.MyListener;



@Configuration
public class MyWebConfiguration implements WebMvcConfigurer{

	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/dologin");
	}
	
	
	
	
	
	@Bean
	public FilterRegistrationBean  filterRegister() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new LoginFilter());
		filterBean.addUrlPatterns("/*");
		return filterBean;
	}
	
	@Bean
	public ServletListenerRegistrationBean registrationBean() {
		ServletListenerRegistrationBean  registrationBean  = new ServletListenerRegistrationBean();
		registrationBean.setListener(new MyListener());
		System.out.println("");
		return registrationBean;
	}

}
