package org.haoxd.spring.beans.bean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: bean definition 构建实例
 * @Author: haoxd
 * @Version: 1.0
 */
public class BeanDefinitionDemo {


    public static void main(String[] args) {
        // 1 通过 beanDefinitionBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Person.class);
        //设置属性
        beanDefinitionBuilder.addPropertyValue("1", "2").addPropertyValue("2", "3");
        //获取实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(beanDefinition);


        //2 通过 AbstractBeanDefinition 子类 GenericBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Person.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        propertyValues.addPropertyValues(map);
        genericBeanDefinition.setPropertyValues(propertyValues);


        System.out.println(genericBeanDefinition);

        System.out.println(genericBeanDefinition == beanDefinition);

    }
}
