package com.app.service;

import org.springframework.stereotype.Component;

@Component
public class NameFormatter {

    public String format(String name) {
        return name.toUpperCase();
    }
}
