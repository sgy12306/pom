package com.itheima;

import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.itheima.ParseAnno");
            Object o = clazz.newInstance();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                method.invoke(o);
            }
        } catch (Exception e) {

        }
    }
}
