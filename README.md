# spring
spring learning .

spring ioc

1 什么是spring ioc 容器？

    IoC也称为依赖注入(DI)。它是一个过程，对象仅通过构造函数参数、工厂方法的参数或在对象实例被构造或从工厂方法返回后在其上设置的属性setter来定义它们的依赖项(即它们使用的其他对象)。
    容器在创建bean时注入这些依赖项。这个过程基本上是bean本身的反向(因此得名，控制反转)，它通过直接构造类或类似服务定位器模式的机制来控制其依赖项的实例化或位置。

2 beanFactory和factoryBean的区别？

      2.1 beanFactory 是spring ioc最底层的容器  。
      2.2 factoryBean是创建bean的一种方式，帮组实现复杂的初始化逻辑
         2.2.1 源码分析 FactoryBean.java 


3 spring ioc 在启动的适合做了什么准备？

     AbstractApplicationContext#refresh();-----源码
     例如，ioc配置元信息的的读取和解析，ioc生命周期，spring事件发布，国际化等等。清理资源缓存等等
     
     
     
基于注解的bean的实现 AnnotationBeanNameGenerator     


spring bean

1 如何注册一个spring bean ？

         通过 BeanDefinition 和外部单体对象注册 通过ConfigurableListableBeanFactory   
         示例     BeanDefinitionDemo ，AnnotationBeanAliasDemo和SingletonBeanRegistrationDemo
         
         
2 什么是BeanDefinition？   
     
                BeanDefinition描述一个bean实例，关于定义bean的元信息的接口          
                *构造函数参数值，和进一步的信息提供 *具体实现。
                
3 spring 容器是如何管理注册bean的？


4 ObjectFactory 和BeanFactory的区别？    
            
        1 ObjectFactory 和BeanFactory 均提供依赖查找的能力。  
        2 不过 ObjectFactory 仅关注一个或一种类型的bean依赖查找，而且自身是不具备依赖查找的能力，能力是由BeanFactory输出
        3 BeanFactory 则提供了单一类型，集合类型以及层次性等多种依赖查找的能力或者方式。
        
        
5 BeanFactory.getBean操作是否线程安全？

        1 操作是线程安全的，操作的过程当中会增加互斥锁。
        2 DefaultListableBeanFactory#beanDefinitionMap是一个ConcurrentHashMap
        3 操作的方法synchronized 锁住了beanDefinitionMap 
        


                               
                               
                               