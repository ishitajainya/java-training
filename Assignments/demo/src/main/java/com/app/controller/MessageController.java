package com.app.controller;


import com.app.service.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    public MessageController(@Qualifier("hindiService") MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/message/{name}")
    public String getMessage(@PathVariable String name) {
        return messageService.getMessage(name);
    }
}
