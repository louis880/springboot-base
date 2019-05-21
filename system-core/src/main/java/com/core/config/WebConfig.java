package com.core.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.core.properties.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * web 配置类
 *
 * @author LUJIAWEI931
 * @date 2019-05-21
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SystemProperties systemProperties;

    /**
     * 增加swagger的支持
     * 静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (systemProperties.getSwaggerOpen()) {
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }
    }
    
}
