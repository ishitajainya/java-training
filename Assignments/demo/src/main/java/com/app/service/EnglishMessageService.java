package com.app.service;

import org.springframework.stereotype.Service;

@Service("englishService")
public class EnglishMessageService implements MessageService{
	
	@Override
	public String getMessage(String name) {
		return "Hello " + name + " !";
	}
	
}
