package com.zhonghao.common.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import javax.validation.Validator;
import java.util.Properties;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfiguration {
    @Value("${spring.velocity.charset:utf-8}")
    private String charset;


    /**负责处理乱码问题*/
    @Bean
    @ConfigurationProperties(prefix = "spring.velocity")
    public VelocityConfig velocityConfig() {
        VelocityConfigurer configure = new VelocityConfigurer();
        Properties properties = new Properties();
        properties.put("input.encoding",charset);
        properties.put("output.encoding",charset);
        configure.setVelocityProperties(properties);
        return configure;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.velocity")
    public VelocityViewResolver viewResolver() {
        return new VelocityViewResolver();
    }

    @Bean
    public Validator validator() {
        // 默认配置文件ValidationMessages.properties
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MappingJackson2JsonView mappingJackson2JsonView(){
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        view.setObjectMapper(objectMapper);
        return view;
    }


}
