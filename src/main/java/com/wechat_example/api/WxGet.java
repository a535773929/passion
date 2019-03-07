package com.wechat_example.api;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Package: com.wechat_example.util
 * @ClassName: WxGet
 * @Author: tyq
 * @Description: 向指定地址发送Get请求并携带数据
 * @Version: 1.0
 */
public class WxGet {
    public static String get(String url){
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b,0,len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
