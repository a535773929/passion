package com.wechat_example.test;

public class City extends Country {
    String name;
    public void value() {
        name = "Shanghai";
        super.value();      //调用父类的方法
        System.out.println(name);
        System.out.println(super.name);
    }
}
