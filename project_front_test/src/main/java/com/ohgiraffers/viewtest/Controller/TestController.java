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

    @GetMapping("/terms_view")
    public String termsView(){
        return "view/termView";
    }

    @GetMapping("admin")
    public String adminView(){
        return "admin/adminView";
    }

    @GetMapping("admin/login")
    public String adminLoginView(){
        return "admin/adminLoginView";
    }

    @GetMapping("modify_profile")
    public String modifyUserView(){
        return "view/modifyProfileView";
    }

    @GetMapping("/modify_pass")
    public String modifyPass(){
        return "view/modifyPassView";
    }

    @GetMapping("inquiry")
    public String Inquiry(){
        return "view/inquiryView";
    }

    @GetMapping("/inquiry_succ")
    public String inquirySucces(){
        return "view/inquiryRegistSuccess";
    }
}
