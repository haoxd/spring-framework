# spring
spring learning .


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