package org.haoxd.spring.beans.bean;

import org.haoxd.spring.beans.factory.DefaultPersonFactory;
import org.haoxd.spring.beans.factory.PersonFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * @Description: 特殊方式的bean 实例化
 * @Author: haoxd
 * @Version: 1.0
 */
public class SpecialBeanInstaniationtDemo {

    public static void main(String[] args) {


        //配置xml 配置
        //启动上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-specialcreateion-context.xml");


        //applicationcontext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory=applicationContext.getAutowireCapableBeanFactory();


        ServiceLoader<PersonFactory>  serviceLoader=autowireCapableBeanFactory.getBean("personFactoryServiceLoader" ,ServiceLoader.class);



        PersonFactory personFactory= autowireCapableBeanFactory.createBean(DefaultPersonFactory.class);
        System.out.println(personFactory.createPerson());

        echoServiceLoader(serviceLoader);


        specialServiceLoader();

    }


    public  static  void  specialServiceLoader(){
        ServiceLoader<PersonFactory> personFactoryServiceLoader = load(PersonFactory.class,Thread.currentThread().getContextClassLoader());
        echoServiceLoader(personFactoryServiceLoader);

    }

    public  static  void  echoServiceLoader(ServiceLoader<PersonFactory> personFactoryServiceLoader){

        Iterator<PersonFactory> personFactoryIterator  =personFactoryServiceLoader.iterator();
        personFactoryIterator.forEachRemaining(personFactory ->
                System.out.println(personFactory.createPerson())
        );

    }
}
