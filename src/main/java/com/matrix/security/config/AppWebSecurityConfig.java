package com.matrix.security.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: yihaosun
 * @Date: 2021/3/25 08:25
 */
// 声明当前类是一个配置类 相当于XML配置文件
@Configuration
// 声明式配置 启用SpringSecurity安全机制
@EnableWebSecurity
public class AppWebSecurityConfig extends WebSecurityConfigurerAdapter {
}
