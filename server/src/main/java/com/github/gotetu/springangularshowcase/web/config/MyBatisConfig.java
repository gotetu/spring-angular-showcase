package com.github.gotetu.springangularshowcase.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.gotetu.springangularshowcase.dao.mapper")
public class MyBatisConfig {
}
