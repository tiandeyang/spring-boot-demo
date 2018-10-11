package com.dytian.beanpostprocess;

import org.nutz.json.Json;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {


    public static void main(String[] args) {

       /* 我们可以看到Bean的生命周期：
        1、解析xml文件，解析出BeanDefinition
        2、Spring容器创建BeanFactoryPostProcessor实例
        3、调用BeanFactoryPostProcessor的postProcessBeanFactory方法
        4、Spring容器创建BeanPostProcessor实例
        5、在需要创建其他Bean实例的时候创建其他Bean
        6、调用Bean的构造方法
        7、调用Bean的setter方法为Bean属性赋值
        8、调用BeanPostProcessor的postProcessBeforeInitialization方法
        9、调用InitializingBean的afterPropertiesSet方法
        10、调用BeanPostProcessor的postProcessAfterInitialization方法
        11、容器销毁的时候调用DisposableBean的destroy方法*/

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:springxmls/beans.xml");
        TestBean testBean = (TestBean) context.getBean("testBean");
        System.out.println("testBean====="+Json.toJson(testBean));
        context.close();



    }

}
