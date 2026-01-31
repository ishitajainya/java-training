package com.app.controller;


import com.app.service.WelcomeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    private final WelcomeService welcomeService;

    // Constructor Injection
    public WelcomeController(WelcomeService service) {
        this.welcomeService = service;
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return welcomeService.greet(name);
    }
}
