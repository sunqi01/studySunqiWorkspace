package com.dbic.servlet;

import org.springframework.stereotype.Service;

@Service("springServletService")
public class SpringServletService {

	public String say(String name) {
		return "你好啊："+name;
	}
}
