package edu.innotech.inno.configuration;

import edu.innotech.inno.web.interceptors.LoggingControllerInterceptor;
import edu.innotech.inno.web.interceptors.ProductControllerIntrceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationWebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingControllerInterceptor());
        registry.addInterceptor(productControllerIntrceptor())
                .addPathPatterns("/api/v1/product/**");
    }

    @Bean
    public LoggingControllerInterceptor loggingControllerInterceptor(){
        return new LoggingControllerInterceptor();
    }

    @Bean
    public ProductControllerIntrceptor productControllerIntrceptor(){
        return new ProductControllerIntrceptor();
    }
}
