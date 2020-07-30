package org.haoxd.spring.beans.factory;

import javax.annotation.PostConstruct;

/**
 * @Description: 默认 实现
 * @Author: haoxd
 * @Version: 1.0
 */
public class DefaultPersonFactory implements PersonFactory {


    @PostConstruct
    public void init() {
        System.out.println("  基于@PostConstruct注解  DefaultPersonFactory 初始化");

    }

    public void initDefaultPersonFactory() {
        System.out.println("  基于自定义初始化 initDefaultPersonFactory# DefaultPersonFactory 初始化");

    }

}
