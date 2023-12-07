package com.ohgiraffers.pos.menu.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @PostMapping("/adminResp")
    public String handlerMethod(){
        System.out.println("호출");
        return "result";
    }

}
