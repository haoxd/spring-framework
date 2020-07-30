package org.haoxd.spring.beans.bean;

import java.util.Objects;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class Person {

    private String name;

    private Integer age ;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public static  Person createPerson (){

        return  new Person();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
