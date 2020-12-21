package org.haoxd.spring.dependency.lookup;

import org.haoxd.spring.ioc.beans.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;

/**
 * @Description: 通过   ObjectProvider 进行依赖查找
 * @Author: haoxd
 * @Version: 1.0
 * @see org.springframework.beans.factory.ObjectProvider
 */
//@Configuration 是非必须注解
public class ObjectProviderDemo {

    public static void main(String[] args) {


        /***
         *
         * 创建 基于注解的application context
         *
         * **/
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();


        //注册
        annotationConfigApplicationContext.register(ObjectProviderDemo.class);


        //启动上下文
        annotationConfigApplicationContext.refresh();


        //
        lookUpByObjectProvider(annotationConfigApplicationContext);

        lookUpIfAvailable(annotationConfigApplicationContext);

        //关闭spring 上下文
        annotationConfigApplicationContext.close();

    }

    /***
     * 如果
     * @bean 当中没有指定 bean的name, 那么方法名就是bean的名字ss
     * **/
    @Bean
    public String helloWorld() {
        return "helrld";
    }




    private static void lookUpIfAvailable(AnnotationConfigApplicationContext annotationConfigApplicationContext) {

        ObjectProvider<User> contextBeanProvider = annotationConfigApplicationContext.getBeanProvider(User.class);
        User user =contextBeanProvider.getIfAvailable(User::createUser);
        System.out.println(user);
    }


    private static void lookUpByObjectProvider(AnnotationConfigApplicationContext annotationConfigApplicationContext) {

        System.out.println( annotationConfigApplicationContext.getBean("helloWorld",String.class));

        ObjectProvider<String> stringObjectProvider= annotationConfigApplicationContext.getBeanProvider(String.class);
        System.out.println( stringObjectProvider.getObject());
    }
}
