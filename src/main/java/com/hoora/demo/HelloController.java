package com.hoora.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Spring Boot is running!";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registerPage")
    public String registerPage() {
        return "register";
    }
}