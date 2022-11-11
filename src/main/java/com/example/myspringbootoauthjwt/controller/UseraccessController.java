package com.example.myspringbootoauthjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UseraccessController {

    @GetMapping
    public String message(Principal principal){
        return "Welcome"+" "+principal.getName();
    }

}
