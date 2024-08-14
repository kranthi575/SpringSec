package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class LoginController {


    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public String login(){
        System.out.println("Login method triggered");
        return "login.html";
    }


}

