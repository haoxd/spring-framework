package org.haoxd.spring.beans.bean;

import org.haoxd.spring.ioc.beans.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Map;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
@Import(AnnotationBeanAliasDemo.Config.class) // @import
public class AnnotationBeanAliasDemo {


    public static void main(String[] args) throws Exception {

        /***
         *
         * 创建 基于注解的application context
         *
         * **/
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();


        //注册
        annotationConfigApplicationContext.register(AnnotationBeanAliasDemo.class);

        //1 通过 @bean 注解定义
        //2 通过 @Component 来定义
        //3 通过导入 @import

        //启动上下文
        annotationConfigApplicationContext.refresh();

        User user = new User(2, "kex");


        //通过api 注册bean
        registerBeanDefinition(annotationConfigApplicationContext, user, "lex");

        registerBeanDefinition(annotationConfigApplicationContext, user);

        //依赖查找
        Map<String, Config> configBeans = annotationConfigApplicationContext.getBeansOfType(Config.class);
        Map<String, User> userBeans = annotationConfigApplicationContext.getBeansOfType(User.class);
        System.out.println(configBeans);
        System.out.println(userBeans);


        //关闭spring 上下文
        annotationConfigApplicationContext.close();
    }


    /**
     * /**
     *
     * @param beanDefinitionRegistry
     * @param clazz
     * @param beanName
     * @return
     * @Description 命名bean 的注册方式
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry, Object clazz, String beanName) {


        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz.getClass());
        Arrays.stream(clazz.getClass().getDeclaredFields()).forEach(field -> {

            field.setAccessible(true);

            String key = field.getName();
            try {
                Object value = ReflexUtil.getValeByReflex(key, clazz);
                beanDefinitionBuilder.addPropertyValue(key, value);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        //判断bean name 是否存在
        if (StringUtils.hasText(beanName)) {

            //注册bean BeanDefinition
            beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());

        } else {

            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), beanDefinitionRegistry);
        }


    }


    /**
     * @param beanDefinitionRegistry
     * @return
     * @Description 非命名bean 的注册方式
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry, Object clazz) {

        registerBeanDefinition(beanDefinitionRegistry, clazz, null);

    }


    @Component
    public static class Config {


        /***
         *
         *通过java注解没配置bean
         * **/
        @Bean(name = {"user", "kkuser"})
        public User newUserUser() {
            return new User(1, "可可");
        }

    }

}
