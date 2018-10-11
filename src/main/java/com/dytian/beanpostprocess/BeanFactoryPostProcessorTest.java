package com.dytian.beanpostprocess;

import org.nutz.json.Json;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

     //   TestBean testBean = (TestBean) configurableListableBeanFactory.getBean("testBean");
     //   configurableListableBeanFactory.preInstantiateSingletons();
     //   System.out.println(Json.toJson(testBean));
        System.out.println("BeanFactoryPostProcessorTest->postProcessBeanFactory");


    }
}
