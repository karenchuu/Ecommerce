package com.karenchu.mall;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除swagger的路徑配置
        String[] swaggerExcludes=new String[]{"/swagger-ui.html","/swagger-resources/**","/webjars/**"};

        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(swaggerExcludes)
                .excludePathPatterns("/error", "/user/login", "/user/register", "/categories", "/products", "/products/*");
    }
}