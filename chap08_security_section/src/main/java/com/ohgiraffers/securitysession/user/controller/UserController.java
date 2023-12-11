package com.ohgiraffers.securitysession.user.controller;

import com.ohgiraffers.securitysession.user.model.dto.SignUpDTO;
import com.ohgiraffers.securitysession.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/signup")
    public void signUp(){

    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute SignUpDTO signUpDTO, ModelAndView mv){
        // 유효성 검사 로직 추가

        int result = memberService.regist(signUpDTO);
        String message;
        if(result > 0){
            message = "회원가입이 완료되었습니다";
            mv.setViewName("auth/login");
        }else {
            message = "회원가입이 실패하였습니다";
            mv.setViewName("user/signup");

        }
        mv.addObject("message", message);
        return mv;
    }
}
