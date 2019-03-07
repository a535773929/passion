package com.wechat_example.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Map;
//将此对象转换成xml格式
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {
    private static final String APPSECRET="b78a9511f1eaab5cf0dee66e4f878cf1";
    private static final String APPID = "wx4d7b3539cabd62d0";

//    xml中添加content属性
    @XStreamAlias("Content")
    private String content;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public TextMessage(Map<String,String> requestMap,String content){
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }
//    处理文字信息并回复
    public static BaseMessage dealTextMessage(Map<String, String> requestMap) {
//        String msg = requestMap.get("Content");
//        if(msg.equals("图文")){
//            String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE#wechat_redirect";
//            url = url.replace("APPID",APPID ).replace("REDIRECT_URI","http://lab413.free.idcfengye.com/wx/getUserInfo").replace("SCOPE","snsapi_userinfo");
//            TextMessage tm1 = new TextMessage(requestMap, "点击<a href=\""+url+"\"此处></a>登陆");
//            return tm1;
//        }

        TextMessage tm = new TextMessage(requestMap,"welcome to passion school!");
        return tm;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "content='" + content + '\'' +
                '}';
    }
}
