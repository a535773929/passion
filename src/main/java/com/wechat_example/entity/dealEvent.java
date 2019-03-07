package com.wechat_example.entity;

import com.wechat_example.entity.BaseMessage;
import com.wechat_example.entity.TextMessage;

import java.util.Map;

public class dealEvent {
    public static BaseMessage dealEvent(Map<String,String> requestMap){
        String event = requestMap.get("Event");
        switch (event){
            //处理点击事件
            case "CLICK":
                return dealClick(requestMap);
            //处理url跳转事件
            case "VIEW":
        }
        return new TextMessage(requestMap,"点击成功");
    }

    private static BaseMessage dealClick(Map<String, String> requestMap) {
        String key = requestMap.get("EventKey");
        switch (key){
            //处理点击事件“111”
            case "111":
                return new TextMessage(requestMap,"你点了一个一级菜单");
            case "222":
                return new TextMessage(requestMap,"你点了一个二级菜单");

        }
        //找不到对应点击事件时
        return new TextMessage(requestMap,"无效点击");

    }
}
