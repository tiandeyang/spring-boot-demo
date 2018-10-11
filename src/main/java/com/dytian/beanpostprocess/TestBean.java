package com.dytian.beanpostprocess;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TestBean implements InitializingBean, DisposableBean {
    private String name;
    private int age;

    public TestBean() {
        System.out.println("TestBean->constrcutor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("TestBean->setter");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("TestBean->setter");
        this.age = age;
    }

    public void destroy() throws Exception {
        System.out.println("TestBean->destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("TestBean->afterPropertiesSet");
    }
}
