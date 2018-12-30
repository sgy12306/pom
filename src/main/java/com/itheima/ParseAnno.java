package com.itheima;

import org.junit.Test;


import java.lang.reflect.Method;
import java.util.Date;

public class ParseAnno {
    @Test
    public void sss() {

        try {
            Class<?> clazz = Class.forName("com.itheima.Test");
            Object obj = clazz.newInstance();


            if (clazz.isAnnotationPresent(MyAnno.class)) {
                System.out.println("hehehe");
            }
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyAnno.class)) {
                    method.invoke(obj);
                    System.out.println("有助解");
                }
            }
        } catch (Exception e) {
        }

    }
    @Test
    public void sss2() {

        try {
            Class<?> clazz = Class.forName("com.itheima.Test2");
            Object obj = clazz.newInstance();


            if (clazz.isAnnotationPresent(MyAnno.class)) {

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                    method.invoke(obj);
                }
            }

        } catch (Exception e) {
        }

    }
}
