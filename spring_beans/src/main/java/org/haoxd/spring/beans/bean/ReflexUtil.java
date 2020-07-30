package org.haoxd.spring.beans.bean;

import org.haoxd.spring.ioc.beans.User;

import java.lang.reflect.Field;
/**
 *
 * 通过反射获取对象的属性名和属性值
 *
 * ***/
public class ReflexUtil {

    public static Object getValeByReflex(String key, Object obj) {
        //获取对象文件数组
        Field[] fieldes = obj.getClass().getDeclaredFields();
        for (Field field : fieldes) {
            //设置权限
            field.setAccessible(true);
            //field.getName() 获取属性名
            if (key.equals(field.getName())) {
                try {
                    //获取属性值
                    return field.get(obj);

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return null;
    }


    public static void main(String[] args) {

        User user = new User(111, "11111");


        String plat = "userId";
        String link = "userName";

        Integer platInteger = (Integer) getValeByReflex(plat, user);
        String linkString = (String) getValeByReflex(link, user);

        System.out.println(platInteger);
        System.out.println(linkString);


    }
}
