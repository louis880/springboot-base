package com.pad.controllers;

import com.core.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String  test1(){
        System.out.println("MMMMMMNNMNM");
        StringUtils.test();
        System.out.println("MMMMMMNNMNM");
        System.out.println("MMMMMMNNMNM");
        System.out.println("MMMMMMNNMNM");
        System.out.println("MMMMMMNNMNM");
        System.out.println("MMMMMMNNMNM");
        System.out.println("MMMMMMNNMNM");
        return "hello";
    }

    @RequestMapping("/hello2")
    public String  test2(){
        StringUtils.test();
        return "/hello3";
    }
}
