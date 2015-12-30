package com.young.java.controller;

import com.young.java.mapper.UserDomain;
import com.young.java.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

	private static Logger log = Logger.getLogger(UserController.class); 
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(method=RequestMethod.GET)
	public UserDomain user() throws IOException{
		return new UserDomain();
	}
}
