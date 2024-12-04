package com.green.greengramver2.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Component
@Configuration //빈등록(DI 주소값 받기 위해) >> WebMvcConfiguration 객체화
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final String uploadPath; //private 에 값을 넣어주기 위해서는 생성자랑 명시적 방법만 가능 (setter x)
    //setter은 객체화 이후에 사용할 수 있음 (final이 붙으면 setter 이용 x)

    public WebMvcConfiguration(@Value("${file.directory}") String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**").addResourceLocations("file:" + uploadPath + "/");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // RestController의 모든 URL에 "/api" prefix를 설정
        configurer.addPathPrefix("api", HandlerTypePredicate.forAnnotation(RestController.class));
    }

}
