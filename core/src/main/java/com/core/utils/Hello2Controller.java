package com.core.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello2Controller {

    @RequestMapping("/hello3")
    public void test3(){
        System.out.println("hello3");
    }

}
