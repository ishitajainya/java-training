package com.app.service;

import org.springframework.stereotype.Service;

@Service("hindiService")
public class HindiMessageService implements MessageService {

    @Override
    public String getMessage(String name) {
    	return "नमस्ते " + name + "!";

    }
}
