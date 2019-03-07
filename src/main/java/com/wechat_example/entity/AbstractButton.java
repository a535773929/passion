package com.wechat_example.entity;

public class AbstractButton {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //有参构造方法

    public AbstractButton(String name)  {
        this.name = name;
    }
}
