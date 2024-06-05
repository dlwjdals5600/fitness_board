package com.fitness.board.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  // 모든 경로에 대해 인터셉터를 적용
                .excludePathPatterns("/login", "/register/add", "/resources/**"); // 로그인, 회원가입 및 리소스 경로는 제외
    }
}
