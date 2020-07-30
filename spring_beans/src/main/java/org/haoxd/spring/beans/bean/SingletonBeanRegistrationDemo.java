package org.haoxd.spring.beans.bean;

import org.haoxd.spring.beans.factory.DefaultPersonFactory;
import org.haoxd.spring.beans.factory.PersonFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: 注册外部bean
 * @Author: haoxd
 * @Version: 1.0
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {


        /***
         *
         * 创建 基于注解的application context
         *
         * **/
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();


        PersonFactory personFactory = new DefaultPersonFactory();

        ConfigurableListableBeanFactory configurableListableBeanFactory=annotationConfigApplicationContext.getBeanFactory();

        //注册外部bean
        configurableListableBeanFactory.registerSingleton("personFactory",personFactory);


        //启动上下文
        annotationConfigApplicationContext.refresh();


        //查找注册进去的bean
        PersonFactory personFactoryBySpringApplicationContext = annotationConfigApplicationContext.getBean("personFactory",PersonFactory.class);

        // 是否一样
        System.out.println(personFactory==personFactoryBySpringApplicationContext);


        //关闭spring 上下文
        annotationConfigApplicationContext.close();



    }
}
