package com.nexusai.SchoolAppSpring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        System.out.println("Session id"+request.getSession().getId());
        return "Hello, World!"+request.getSession().getId();
    }

    @GetMapping("/hello")
    public String helloGreet() {
        return "Hello, Mr. Pugalendi How are you?!";
    }

}
