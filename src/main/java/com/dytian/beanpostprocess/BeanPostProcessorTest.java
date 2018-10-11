package com.dytian.beanpostprocess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BeanPostProcessorTest implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(beanName + "-->" + "BeanPostProcessorTest->postProcessBeforeInitialization");
       // TestBean bean1 = (TestBean) bean;
//        bean1.setAge(19);
//        int age = bean1.getAge();
//        System.out.println("age==before====="+age);
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(beanName + "-->" + "BeanPostProcessorTest->postProcessAfterInitialization");
//        TestBean bean1 = (TestBean) bean;
//        bean1.setAge(20);
//        int age = bean1.getAge();
//        System.out.println("age=after==="+age);
        return bean;
    }
}
