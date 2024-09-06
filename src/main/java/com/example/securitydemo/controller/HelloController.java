package com.example.securitydemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/test")
    public String testHello(){
        return "Hello Nabin Ghosh";
    }
}
