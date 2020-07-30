package org.haoxd.spring.beans.bean;

import org.haoxd.spring.ioc.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: bean 别名实例
 * @Author: haoxd
 * @Version: 1.0
 */
public class BeanAliasDemo {


    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definition-context.xml");
        User userAlias =beanFactory.getBean("bai-nq-user",User.class);
        User user =beanFactory.getBean("user",User.class);
        System.out.println(user==userAlias);
    }

}
