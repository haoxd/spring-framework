package org.haoxd.spring.ioc.container;

import org.haoxd.spring.ioc.annotation.Super;
import org.haoxd.spring.ioc.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @Description: Application 作为ioc 容器演示
 * @Author: haoxd
 * @Version: 1.0
 */
@Configuration
public class AnnotationApplicationAsIocContainerDemo {

    public static void main(String[] args) {
        //创建beanFactory 容器

        //创建一个基于注解的applicationontext
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //当前类作为配置类
        annotationConfigApplicationContext.register(AnnotationApplicationAsIocContainerDemo.class);
        //启动应用上下文
        annotationConfigApplicationContext.refresh();
        lookupConnectionByAnnotationType(annotationConfigApplicationContext);

    }

    /***
     *
     *通过java注解没配置bean
     * **/
    @Bean
    public User newUserUser(){
        return new User(1,"紫衣");
    }

    /***
     * 根据注解查找
     * @param  beanFactory
     *
     * ***/
    private static void lookupConnectionByAnnotationType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> userMap= listableBeanFactory.getBeansOfType(User.class);

            userMap.forEach((k,v)->System.out.println(k+","+v.toString()));
        }
    }


}
