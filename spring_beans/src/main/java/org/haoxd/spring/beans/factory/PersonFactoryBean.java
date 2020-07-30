package org.haoxd.spring.beans.factory;

import org.haoxd.spring.beans.bean.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class PersonFactoryBean implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        return Person.createPerson();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
