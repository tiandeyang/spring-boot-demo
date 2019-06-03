package com.dytian.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    /**
     * bean工厂的bean属性处理容器，说通俗一些就是可以管理我们的bean工厂内所有的beandefinition（未实例化）数据，可以随心所欲的修改属性。
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

     //   TestBean testBean = (TestBean) configurableListableBeanFactory.getBean("testBean");
     //   configurableListableBeanFactory.preInstantiateSingletons();
     //   System.out.println(Json.toJson(testBean));
    //    System.out.println("BeanFactoryPostProcessorTest->postProcessBeanFactory");

        System.out.println("调用了自定义的BeanFactoryPostProcessor " + beanFactory);
        Iterator it = beanFactory.getBeanNamesIterator();

        String[] names = beanFactory.getBeanDefinitionNames();
        // 获取了所有的bean名称列表
        for(int i=0; i<names.length; i++){
            String name = names[i];
            BeanDefinition bd = beanFactory.getBeanDefinition(name);
            System.out.println(name + " bean properties: " + bd.getPropertyValues().toString());
            // 本内容只是个demo，打印持有的bean的属性情况
        }

    }
}
