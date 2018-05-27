package com.example.lunchbox.configuration;

import com.example.lunchbox.intercepor.RequestInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver ViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).excludePathPatterns("/").excludePathPatterns("/admin/login").excludePathPatterns("/admin/signup")
        .excludePathPatterns("/login").excludePathPatterns("/signup").excludePathPatterns("/customer/login").excludePathPatterns("/customer/signup")
        .excludePathPatterns("/foodmaker/login").excludePathPatterns("/foodmaker/signup").excludePathPatterns("/rider/login").excludePathPatterns("/rider/signup");
    }


    @Bean
    public FilterRegistrationBean corsFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(getCharacterEncodingFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    @Bean(name = "encodingFilter")
    public CharacterEncodingFilter getCharacterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
