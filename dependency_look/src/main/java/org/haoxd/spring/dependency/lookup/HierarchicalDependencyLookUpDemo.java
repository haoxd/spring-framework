package org.haoxd.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: 层次性依赖查找实例
 * @Author: haoxd
 * @Version: 1.0
 */
public class HierarchicalDependencyLookUpDemo {

    public static void main(String[] args) {

        //创建基于注解的spring ioc 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //
        annotationConfigApplicationContext.register(HierarchicalDependencyLookUpDemo.class);


        //1 继承层级 ConfigurableListableBeanFactory ->  ConfigurableBeanFactory ->  HierarchicalBeanFactory

        ConfigurableListableBeanFactory configurableListableBeanFactory = annotationConfigApplicationContext.getBeanFactory();


        System.out.println("当前bean factory 的 parent beanfactory ：" + configurableListableBeanFactory.getParentBeanFactory());

        //2 设置parent beanfactory
        HierarchicalBeanFactory hierarchicalBeanFactory = initBeanFactory();
        configurableListableBeanFactory.setParentBeanFactory(hierarchicalBeanFactory);
        System.out.println("当前bean factory 的 parent beanfactory ：" + configurableListableBeanFactory.getParentBeanFactory());

        //
        disPlayContainsLocalBean(configurableListableBeanFactory, "user");
        disPlayContainsLocalBean(hierarchicalBeanFactory, "user");
        displayContainsBean(configurableListableBeanFactory, "user");
        displayContainsBean(hierarchicalBeanFactory, "user");

        //启动应用上下文
        annotationConfigApplicationContext.refresh();

        // 关闭应用上下文
        annotationConfigApplicationContext.close();

    }


    private static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {


        System.out.printf
                ("当前beanfactory [%s] 是否包含 Local bean [name : %s] : %s \n", beanFactory, beanName, containsBean(beanFactory, beanName));

    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {

        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();

        if (parentBeanFactory instanceof HierarchicalBeanFactory) {

            HierarchicalBeanFactory hierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (containsBean(hierarchicalBeanFactory, beanName)) {
                return Boolean.TRUE;
            }
        }
        return beanFactory.containsLocalBean(beanName);


    }

    private static void disPlayContainsLocalBean(HierarchicalBeanFactory hierarchicalBeanFactory, String beanName) {

        System.out.printf
                ("当前beanfactory [%s] 是否包含 Local bean [name : %s] : %s \n", hierarchicalBeanFactory, beanName, hierarchicalBeanFactory.containsLocalBean(beanName));


    }


    /**
     * 初始化 BeanFactory ioc 容器
     *
     * @return BeanFactory {@link BeanFactory}
     **/
    private static ConfigurableListableBeanFactory initBeanFactory() {

        //创建beanFactory 容器


        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        //加载配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";

        xmlBeanDefinitionReader.loadBeanDefinitions(location);

        return defaultListableBeanFactory;


    }

}
