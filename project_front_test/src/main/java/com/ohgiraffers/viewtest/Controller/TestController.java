package com.ohgiraffers.viewtest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class TestController {

    @GetMapping("/login_view")
    public String loginView(){
        return "view/loginView";
    }

    @GetMapping("/find_pass")
    public String findPassView(){
        return "view/findPassView";
    }

    @GetMapping("/signup_view")
    public String signUpView(){
        return "view/signUpView";
    }
}
