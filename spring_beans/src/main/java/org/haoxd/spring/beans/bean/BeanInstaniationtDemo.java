package org.haoxd.spring.beans.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: bean 实例化演示
 * @Author: haoxd
 * @Version: 1.0
 */
public class BeanInstaniationtDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-createion-context.xml");


        Person personStatic  = beanFactory.getBean("user-static-method",Person.class);

        Person personInit  = beanFactory.getBean("user-init-method",Person.class);

        Person personFactory  = beanFactory.getBean("factoryPersonBean",Person.class);


        System.out.println(personFactory);
        System.out.println(personStatic);
        System.out.println(personInit);
        System.out.println(personInit==personStatic);
        System.out.println(personInit.equals(personStatic));

    }



}
