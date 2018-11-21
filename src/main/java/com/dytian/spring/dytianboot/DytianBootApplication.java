package com.dytian.spring.dytianboot;

import com.dytian.spring.dytianboot.config.DbConfig;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;


@ServletComponentScan
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


    @Autowired
    DbConfig dbConfig;



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


    @Bean
    PageHelper pageHelper(){
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
        return pageHelper;
    }





}
