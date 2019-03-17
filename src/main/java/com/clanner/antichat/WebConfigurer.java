package com.clanner.antichat;

import com.clanner.antichat.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Clanner
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/AntiChat/**")
                .excludePathPatterns("/AntiChat/User/register")
                .excludePathPatterns("/AntiChat/User/register");
        super.addInterceptors(registry);
    }
}
