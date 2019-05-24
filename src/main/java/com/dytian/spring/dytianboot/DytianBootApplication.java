package com.dytian.spring.dytianboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SpringBootApplication
@PropertySource(value = "classpath:db.properties",encoding="utf-8")
@MapperScan("com.dytian.mapper")
@ComponentScan("com.dytian.*")
@EnableRedisHttpSession
public class DytianBootApplication {


    @Value("${master.name}")
    String masterName;

    @Value("${db.name}")
    String dbName;

    @Value("${dytian.name}")
    String dytian;

    public static void main(String[] args) {
        SpringApplication.run(DytianBootApplication.class, args);
    }

    @GetMapping(value = "/hello")
    public Object sayHell(@RequestParam("name") String name){
        return "hello "+masterName + dytian;
    }

    @GetMapping(value = "/hello2/{name}")
    public Object sayHell2(@PathVariable("name") String name){
        Long.parseLong("xyz");
        return "hello "+masterName + dytian;
    }






}
