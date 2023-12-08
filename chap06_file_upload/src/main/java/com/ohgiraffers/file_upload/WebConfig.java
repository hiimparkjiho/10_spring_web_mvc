package com.ohgiraffers.file_upload;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {    // web Application에서 리소스 추가


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")  // 정적 리소스에 대한 핸들러 추가하는 메서드 img/** 요청시 응답하다.
                .addResourceLocations("classpath:/static/img/")  // 해당 요청에 메핑될 경로
                .setCachePeriod(20);    // 클라이언트의 캐싱 유지 시작
    }
}
