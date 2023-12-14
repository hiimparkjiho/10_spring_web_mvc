package com.ohgiraffers.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/login")
    public String loginView(){
        return "test/loginView";
    }

    @RequestMapping("/find_pass")
    public String findPassView(){
        return "test/findPassView";
    }
}
