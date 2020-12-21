package org.haoxd.spring.aop.overview;

/**
 * @Description:类加载示例
 * @Author: haoxd
 * @Version: 1.0
 */
public class ClassLoadingDemo {


    public static void main(String[] args) {

        ClassLoader classLoader =Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader);

        ClassLoader parentClassLoader = classLoader;

        while (true){

            parentClassLoader =parentClassLoader.getParent();

            if(parentClassLoader == null){
                break;
            }
            System.out.println(parentClassLoader);
        }

    }

}
