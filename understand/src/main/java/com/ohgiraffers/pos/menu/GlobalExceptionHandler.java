//package com.ohgiraffers.pos.menu;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public String ExceptionHandler(Exception e, Model model){
//        model.addAttribute("message", "익셉션 발생");
//        System.out.println("exception 발생함");
//        return "error/default";
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    public String nullPointException(NullPointerException e, Model model){
//        model.addAttribute("message", "널 위한 널 포인트 익셉션");
//        System.out.println("null point 익셉션 발생");
//        return "error/default";
//    }
//
//}
