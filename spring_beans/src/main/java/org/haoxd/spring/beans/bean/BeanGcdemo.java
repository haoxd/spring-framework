package org.haoxd.spring.beans.bean;

import org.haoxd.spring.beans.factory.PersonFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: spring gc demo
 * @Author: haoxd
 * @Version: 1.0
 */
public class BeanGcdemo {

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




        //关闭spring 上下文
        annotationConfigApplicationContext.close();


        //强制gc
        System.gc();

    }
}
