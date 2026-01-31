package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class NameFormatService {

    private final NameFormatter formatter;

    public NameFormatService(NameFormatter formatter) {
        this.formatter = formatter;
    }

    public String greet(String name) {
        return "Welcome " + formatter.format(name) + "!";
    }
}
