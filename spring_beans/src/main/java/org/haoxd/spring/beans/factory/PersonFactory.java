package org.haoxd.spring.beans.factory;

import org.haoxd.spring.beans.bean.Person;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public interface PersonFactory {


    default Person createPerson() {
        Person person = new Person();
        person.setAge(1);
        person.setName("qingmeng");
        return  person;

    }
}
