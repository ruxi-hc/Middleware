package com.ruxi.sen1.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user1")
public class TestController {

    @RequestMapping("/list")
    public String test(){
        return "你好";
    }
}
