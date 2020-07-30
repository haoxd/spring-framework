package org.haoxd.spring.ioc.dependency.lookup;

import org.haoxd.spring.ioc.annotation.Super;
import org.haoxd.spring.ioc.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @Description: 依赖查找实例
 * @Author: haoxd
 * @Version: 1.0
 */
public class DependencyLookUpDemo {

    public static void main(String[] args) {

        //配置xml 配置
        //启动上下文
        //用于访问Spring bean容器的根接口。这是bean容器的基本客户端视图
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");


        //lookupInRearTime(beanFactory);

        //lookupInLayzTime(beanFactory);

        //lookupByType(beanFactory);

        //lookupConnectionByType(beanFactory);


        lookupConnectionByAnnotationType(beanFactory);
    }

    /***
     * 根据注解查找
     * @param  beanFactory
     *
     * ***/
    private static void lookupConnectionByAnnotationType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, Object> userMap= listableBeanFactory.getBeansWithAnnotation(Super.class);

            userMap.forEach((k,v)->System.out.println(k+","+v.toString()));
        }
    }


    /***
     * 查找list
     * @param  beanFactory
     *
     * ***/
    private static void lookupConnectionByType(BeanFactory beanFactory) {

      if (beanFactory instanceof ListableBeanFactory) {
          ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

        Map<String,User> userMap= listableBeanFactory.getBeansOfType(User.class);

          userMap.forEach((k,v)->{

              System.out.println(k);
              System.out.println(v);


          });
      }

    }

    /***
     * 根据类型查找
     * @param  beanFactory
     *
     * ***/
    private static void lookupByType(BeanFactory beanFactory) {

      User user=  beanFactory.getBean(User.class);

      System.out.println(user);


    }

    /***
     * 实时查找
     * @param  beanFactory
     *
     * ***/
    private static  void lookupInRearTime( BeanFactory beanFactory ){
        User user=beanFactory.getBean("user",User.class);
        System.out.println(user);


    }

    /***
     * 延时查找
     * @param  beanFactory
     *
     * ***/
    private static  void lookupInLayzTime( BeanFactory beanFactory ){
        ObjectFactory<User> objectFactory=beanFactory.getBean("objectFactory", ObjectFactory.class);
        System.out.println(objectFactory.getObject());


    }
}
