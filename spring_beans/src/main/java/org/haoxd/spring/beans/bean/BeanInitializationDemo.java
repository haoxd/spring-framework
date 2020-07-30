package org.haoxd.spring.beans.bean;

import org.haoxd.spring.beans.factory.DefaultPersonFactory;
import org.haoxd.spring.beans.factory.PersonFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: baan 初始化
 * @Author: haoxd
 * @Version: 1.0
 */
@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {


            /***
             *
             * 创建 基于注解的application context
             *
             * **/
            AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();


            //注册
            annotationConfigApplicationContext.register(BeanInitializationDemo.class);


            //启动上下文
            annotationConfigApplicationContext.refresh();

            //依赖查找 personFactory
            PersonFactory personFactory = annotationConfigApplicationContext.getBean(PersonFactory.class);


            //关闭spring 上下文
            annotationConfigApplicationContext.close();

    }


    @Bean(initMethod = "initDefaultPersonFactory" ,destroyMethod = "doDestroy")
    public PersonFactory personFactory() {

        return new DefaultPersonFactory();

    }
}
