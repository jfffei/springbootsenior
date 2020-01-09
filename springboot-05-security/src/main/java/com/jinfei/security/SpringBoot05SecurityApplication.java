package com.jinfei.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* 1、引入 SpringSecurity
* 2、编写 SpringSecurity 的配置类
*   @EnableWebSecurity
    public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    }
*3、控制请求的权限访问
*
*
*
*
*/
@SpringBootApplication
public class SpringBoot05SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05SecurityApplication.class, args);
    }

}
