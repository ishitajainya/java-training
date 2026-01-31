package com.app.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Value("${app.author}")
    private String author;

    @GetMapping("/author")
    public String author() {
        return author;
    }
}
