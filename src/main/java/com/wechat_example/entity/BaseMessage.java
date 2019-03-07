package com.wechat_example.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
public class BaseMessage {
    @XStreamAlias("ToUserName")
    private String toUserName;
    @XStreamAlias("FromUserName")
    private  String fromUserName;
    @XStreamAlias("CreateTime")
    private  String creatTime;
    @XStreamAlias("MsgType")
    private  String msgType;
    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    public BaseMessage(Map<String,String> requestMap){
        this.toUserName = requestMap.get("FromUserName");
        this.fromUserName = requestMap.get("ToUserName");
        this.creatTime = System.currentTimeMillis()/1000+"";
    }

    @Override
    public String toString() {
        return "BaseMessage{" +
                "toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
