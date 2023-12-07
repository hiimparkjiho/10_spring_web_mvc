package com.ohgiraffers.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private StopWatchInterceptor stopWatchInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopWatchInterceptor)
                .addPathPatterns("/stopwatch")  // 모든 요청에 허용
                .excludePathPatterns("/css/**")// css 하위에 있는 요청은 허용하지 않는다
                .excludePathPatterns("/images/**")// images 하위에 요청은 허용하지 않는다
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/error");
    }
}
