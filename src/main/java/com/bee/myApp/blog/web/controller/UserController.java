package com.bee.myApp.blog.web.controller;

import com.bee.myApp.blog.dao.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * 
 * @author Linfeng
 *
 */
@Controller
public class UserController {
	
	@RequestMapping(value="/json",method=RequestMethod.POST)
	@ResponseBody
	public Object test(HttpServletRequest request,@RequestBody User user){
		System.err.println(request.getSession().getServletContext());
		System.out.println(request.getServletContext());
		return user;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public Object getTest(HttpServletRequest request, String name, String age, Date date){
		String remoteAddr = request.getRemoteAddr();
		String remotHost = request.getRemoteHost();
		int port = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		System.out.println(port+ "sdaf");
		if(StringUtils.isEmpty(name)){
			
		}
		User user = new User(name, age);
		user.setCreateTime(date);
		System.out.println(remoteUser);
		return user;
	}
	
	@RequestMapping(value="/json",method=RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public String getJson(HttpServletRequest request) throws Exception{
		
		User user = new User("dd","sss");
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		String json = objectMapper.writeValueAsString(user);
		return json;
	}
	
}
