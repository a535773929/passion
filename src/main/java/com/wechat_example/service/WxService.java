package com.wechat_example.service;

import com.wechat_example.entity.BaseMessage;
import com.wechat_example.entity.TextMessage;
import com.wechat_example.pojo.AccessToken;
import com.wechat_example.util.BeanToXml;
import com.wechat_example.api.WxGet;
import net.sf.json.JSONObject;


import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Map;


public class WxService {
//    @Value("${APPID}")
    public static String APPID = "wx4d7b3539cabd62d0";
    private static final String APPSECRET="b78a9511f1eaab5cf0dee66e4f878cf1";
    private static final String GET_TOKEN_URLL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private static AccessToken at;
    private static void getToken(){
        String url = GET_TOKEN_URLL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        String tokenstr = WxGet.get(url);
        System.out.println(tokenstr);
        JSONObject jsonObject = JSONObject.fromObject(tokenstr);
        String token = jsonObject.getString("access_token");
        String expireIN = jsonObject.getString("expires_in");
//        创建Token对象并存储
        at = new AccessToken(token,expireIN);
    }
//    外部调用获取Token方法
    public static String getAccessToken(){
        if(at==null||at.isExpired()){
            getToken();
        }
//        此处返回的at.getAccess_token()是Access对象at中的Access_token属性值，而非本方法递归。
        return at.getAccess_token();
    }





//    用于处理接收的消息并回复

    public static String getResponse(Map<String,String> requestMap){
        BaseMessage msg = null;
//        String msgType = requestMap.get("MsgType");
//        根据不同消息类型回复不同消息
//        switch (msgType){
//            case "text":
//                msg = TextMessage.dealTextMessage(requestMap);
//                break;
//            case "image":
//                break;
//            case "voice":
//                break;
//            case "video":
//                break;
//            case "shortvideo":
//                break;
//            case "link":
//                break;
//            case "event":
//                msg = dealEvent(requestMap);
//        }

//        统一回复文字信息
        msg = TextMessage.dealTextMessage(requestMap);
        if(msg!=null){
        System.out.println("准备回复："+msg);
//        把消息转换为XML数据包
        return BeanToXml.beanToXml(msg);}
    else {return null;}
}





    //获取用户信息
    // {"subscribe":1,"openid":"o5Slv5iEiAimoMS2h3kJBRzhY_NA","nickname":"La Campanella","sex":1,"language":"zh_CN","city":"成都","province":"四川","country":"中国","headimgurl":"http:\/\/thirdwx.qlogo.cn\/mmopen\/R8icoMVs6SqPaF7YGk9ddFkRNnqCUwFsd7SVoniaBNfED1H7AKoia0YCTMT2uEQXxxedFxYbU1lRvkBXRtwkYveyI94zxiaWoJ6w\/132","subscribe_time":1544491919,"remark":"","groupid":0,"tagid_list":[],"subscribe_scene":"ADD_SCENE_QR_CODE","qr_scene":0,"qr_scene_str":""}

    public static String getUserInfo(String openid){
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url = url.replace("ACCESS_TOKEN",getAccessToken()).replace("OPENID",openid);
        String result = WxGet.get(url);
        return result;
    }


}

