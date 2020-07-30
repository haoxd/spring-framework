package org.haoxd.spring.ioc.repository;

import org.haoxd.spring.ioc.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @Description:用户仓储
 * @Author: haoxd
 * @Version: 1.0
 */
public class UserRepository {

    private Collection<User> users;


    private BeanFactory beanFactory;


    private ObjectFactory<ApplicationContext> userObjectFactory;

    public ObjectFactory<ApplicationContext> getUserObjectFactory() {
        return userObjectFactory;
    }

    public void setUserObjectFactory(ObjectFactory<ApplicationContext> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }



    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "users=" + users +
                ", beanFactory=" + beanFactory +
                ", userObjectFactory=" + userObjectFactory +
                '}';
    }
}
