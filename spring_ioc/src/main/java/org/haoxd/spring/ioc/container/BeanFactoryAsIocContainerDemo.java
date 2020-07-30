package org.haoxd.spring.ioc.container;

import org.haoxd.spring.ioc.annotation.Super;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @Description: BeanFactory 作为ioc 容器演示
 * @Author: haoxd
 * @Version: 1.0
 */
public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        //创建beanFactory 容器



        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        //加载配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String location="classpath:/META-INF/dependency-lookup-context.xml";

        int beans = xmlBeanDefinitionReader.loadBeanDefinitions(location);

        System.out.println(beans);

        lookupConnectionByAnnotationType(defaultListableBeanFactory);
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


}
