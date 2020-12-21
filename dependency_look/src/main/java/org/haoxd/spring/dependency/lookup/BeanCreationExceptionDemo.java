package org.haoxd.spring.dependency.lookup;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @Description: {@link BeanCreationException} bean创建异常示例
 * @Author: haoxd
 * @Version: 1.0
 */
public class BeanCreationExceptionDemo {

    public static void main(String[] args) {


        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册beanDefinition bean class 是 一个 Pojo的普通类。不过初始化抛出异常
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Pojo.class);
        applicationContext.registerBeanDefinition("errorBean", beanDefinitionBuilder.getBeanDefinition());
        // 启动应用上下文
        applicationContext.refresh();


        // 关闭应用上下文
        applicationContext.close();

    }

    static class Pojo implements InitializingBean {

        @PostConstruct
        public void init() throws Exception {
            throw new Exception("for init ex");

        }


        /**
         * Invoked by the containing {@code BeanFactory} after it has set all bean properties
         * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
         * <p>This method allows the bean instance to perform validation of its overall
         * configuration and final initialization when all bean properties have been set.
         *
         * @throws Exception in the event of misconfiguration (such as failure to set an
         *                   essential property) or if initialization fails for any other reason
         */
        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("for afterPropertiesSet ex");
        }
    }
}

