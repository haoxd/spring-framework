package org.haoxd.spring.dependency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Description: {@link NoUniqueBeanDefinitionException} 示例
 * @Author: haoxd
 * @Version: 1.0
 */
public class NoUniqueBeanDefinitionExceptionDemo {


    public static void main(String[] args) {

        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 NoUniqueBeanDefinitionExceptionDemo 作为配置类（Configuration Class）
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        // 启动应用上下文
        applicationContext.refresh();

        try {
            applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            System.out.println("个数：" + e.getNumberOfBeansFound());
            System.out.println("类型：" + String.class.getName());
            System.out.println("错误类型：" + e.getMessage());
        }


        // 关闭应用上下文
        applicationContext.close();

    }

    @Bean
    public String bean1() {
        return "bean1";
    }

    @Bean
    public String bean2() {
        return "bean2";
    }

    @Bean
    public String bean3() {
        return "bean3";
    }
}
