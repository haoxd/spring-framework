package org.haoxd.spring.beans.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description: 默认 实现
 * @Author: haoxd
 * @Version: 1.0
 */
public class DefaultPersonFactory implements PersonFactory ,InitializingBean,DisposableBean{

    //实例化
    @PostConstruct
    public void init() {
        System.out.println("  基于@PostConstruct注解  DefaultPersonFactory 初始化");

    }

    public void initDefaultPersonFactory() {
        System.out.println("  基于自定义初始化 initDefaultPersonFactory# DefaultPersonFactory 初始化");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("  基于自定义初始化 afterPropertiesSet# DefaultPersonFactory 初始化");
    }


    //销毁
    @PreDestroy
    public void PreDestroy() {
        System.out.println("  基于@PreDestroy注解  DefaultPersonFactory 销毁中");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("  基于DisposableBean#destroy()注解  DefaultPersonFactory 销毁中");
    }


    public void doDestroy() throws Exception {
        System.out.println("  基于自定义#doDestroy()方法 DefaultPersonFactory 销毁中");
    }


    @Override
    protected void finalize() throws Throwable {

        System.out.println("DefaultPersonFactory 进行gc。。。。。。。。。。。" );

    }
}
