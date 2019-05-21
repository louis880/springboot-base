package com.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController3 {

    @RequestMapping("/hello33")
    @ResponseBody
    public String test4(){
        System.out.println(">>>>>>>");
        System.out.println("test4");
        System.out.println(">>>>>><<<<<<");
        System.out.println(">>>>>><<<<<<");
        System.out.println(">>>>>><<<<<<");
        return "";
    }


}
