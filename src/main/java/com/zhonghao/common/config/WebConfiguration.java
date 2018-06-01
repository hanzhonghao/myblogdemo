package com.zhonghao.common.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhonghao.common.constant.SystemConst;
import com.zhonghao.common.security.SecurityInterceptor;
import com.zhonghao.component.LocalCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.velocity.VelocityConfig;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import javax.validation.Validator;
import java.util.Properties;


@Slf4j
@SuppressWarnings("deprecation")
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{
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

    /**将自己的拦截器加入*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/**");
    }

    /**资源处理器*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 特别注意 在win环境下 路径最后一定要加"/"
        String uploadUrl = LocalCache.getValue("upload_url");
        if (uploadUrl != null && !uploadUrl.endsWith("/")) {
            uploadUrl += "/";
        }
        log.info("====>uploadUrl:{}", uploadUrl);
        registry.addResourceHandler(SystemConst.STATIC_PREFIX + "/**").addResourceLocations("file:" + uploadUrl);
    }
}
