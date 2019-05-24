package com.dytian.spring.dytianboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@MapperScan("com.dytian.mapper*")
public class MybatisPlusConfig {




}
