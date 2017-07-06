package com.sun.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.dao.UserMapper;
import com.sun.model.User;


@RestController
@RequestMapping("/test")
public class TestController {

	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("/hello")  
	public String hello(){  
		return "Hello world!";  
	}  
	
	@RequestMapping("/all")
	public String findAll(Map<String,Object> map){
	    List<User> userList = userMapper.selectAll();
	    map.put("hello","from TestController.helloHtml");
	    map.put("userList",userList);
		return map.toString();
	}
}
