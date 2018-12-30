package com.itheima;

import sun.net.idn.Punycode;

import java.security.PublicKey;

public class Test {
    public static void main(String[] args) {
        get();
        System.out.println("ddd");
    }
    @MyAnno
    public static void get() {
        System.out.println("执行get");
    }
}
