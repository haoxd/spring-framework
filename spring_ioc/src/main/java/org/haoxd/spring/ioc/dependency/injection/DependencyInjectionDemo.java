package org.haoxd.spring.ioc.dependency.injection;

import org.haoxd.spring.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @Description: 依赖注入实例
 *
 * 所以spring依赖来自三个方向
 * 一 ： 自定义bean
 * 二 ：内部容器构建的bean
 * 三 ：内部容器构建的依赖
 *
 * @Author: haoxd
 * @Version: 1.0
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        //配置xml 配置
        //启动上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-inject-context.xml");
        applicationContext.getParentBeanFactory();
        //自定义bean
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);

        //内部依赖bean
        ObjectFactory<ApplicationContext> userObjectFactory = userRepository.getUserObjectFactory();

        System.out.println(userObjectFactory.getObject()==beanFactory);
        //容器内建bean
        Environment environment  =beanFactory.getBean(Environment.class);
        System.out.println(environment);


        whoIsIOC(beanFactory,userRepository);
    }
    /***
     *  BeanFactory 和 ApplicationContext
     * 到底谁是ioc容器
     * ApplicationContext is BeanFactory ,更多针对企业的功能 是对一个完整的超集BeanFactory
     * BeanFactory :提供了配置框架和基本功能,spring底层ioc容器
     * */
    private  static void whoIsIOC( BeanFactory beanFactory ,UserRepository userRepository ){
        System.out.println(beanFactory == userRepository.getBeanFactory());

    }


}
