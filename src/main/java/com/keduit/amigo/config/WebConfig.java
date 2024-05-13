package com.keduit.amigo.config;


import com.keduit.amigo.component.DashboardInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// /dashboard/ 경로로 시작하는 모든 웹 요청을
// src/main/resources/static/ 경로 아래에서 찾도록 지시.

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private DashboardInterceptor dashboardInterceptor;

    // 정적 리소스 경로 설정(CSS, JS, JQuery 등)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/dashboard/**")
                .addResourceLocations("classpath:/static/");
    }

    // 인터셉터 등록(사용자 접근 정보 가로챔)
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dashboardInterceptor).addPathPatterns("/api/**");
    }
}

