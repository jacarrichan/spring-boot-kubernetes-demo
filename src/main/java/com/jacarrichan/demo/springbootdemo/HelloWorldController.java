package com.jacarrichan.demo.springbootdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "Hello World\t" + new Date();
    }
}