package com.learn.springaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.learn.springaop")
@EnableAspectJAutoProxy
public class BeanConfig {

}
