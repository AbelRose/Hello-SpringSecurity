package com.matrix.security.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //   super.configure(http); 默认的权限规则 所有的请求都受限
        // 实验一: 授权首页和静态资源
        http.authorizeRequests()
                .antMatchers("/layui/**", "/index.jsp").permitAll()  // /* 表示下面的一级路径 /**表示所有的路径 permitAll() 表示放行
                .anyRequest().authenticated();  // 其他的需要认证 不能放行

        // 实验二: 默认及自定义登陆页
        // http.formLogin();  // 出错的时候来到默认登陆页 比较难看
        // http.formLogin().loginPage("/index.jsp"); 自定义的登陆页
        http.formLogin().loginPage("index.jsp")
                .usernameParameter("loginacct")  // index.jsp 设置登陆label的名字
                .passwordParameter("userpswd")   // index.jsp 设置密码label的名字
                .loginProcessingUrl("/doLogin")  // index.jsp 表单提交的路径 默认是/login
                .successForwardUrl("/main.html");//  成功时候跳转的页面
        http.csrf().disable();  // 禁用CSRF
    }
}
