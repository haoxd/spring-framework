package org.haoxd.spring.beans;

import org.haoxd.spring.beans.bean.Person;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;


/**
 * @Description: propertyDescriptor
 * @Author: haoxd
 * @Version: 1.0
 */
public class BeanInfoDemo {


    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> System.out.println(propertyDescriptor));



    }
}
