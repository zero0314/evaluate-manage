package com.zero314.evaluatemanage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;

/**
 * @author yh
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Value("${file.path}")
    private String path;

    /**
     * 路径访问配置
     *
     * @param registry 注册表
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("------->>" + path);
        // 将/static/**映射到工程路径下的 /static/
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // 将/public/**映射到磁盘目录
        registry.addResourceHandler("/public/**").addResourceLocations("file:" + path);

    }

    /**
     * 跨域需要进行请求配置，规定那个请求允许跨域访问
     *
     * @param registry 注册表
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //设置放行哪些原始域   SpringBoot2.4.4下低版本使用.allowedOrigins("*")
                .allowedOriginPatterns("*")
                //放行哪些请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //.allowedMethods("*") //或者放行全部
                //放行哪些原始请求头部信息
                .allowedHeaders("*")
                //暴露哪些原始请求头部信息
                .exposedHeaders("*");
    }

    /**
     * 全局设置编码格式
     */
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }


}

