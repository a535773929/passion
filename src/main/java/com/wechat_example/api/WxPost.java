package com.wechat_example.api;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Package: com.wechat_example.util
 * @ClassName: WxPost
 * @Author: tyq
 * @Description: 向指定地址发送Post请求并携带数据
 * @Version: 1.0
 */
public class WxPost {
    public static String post(String url,String data) {
        try{
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            //发送数据前必须先设置为可发送状态
            connection.setDoOutput(true);
            OutputStream os = connection.getOutputStream();
            os.write(data.getBytes());
            os.close();
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len=is.read(b))!=-1){
                sb.append(new String(b,0,len));
            }
            return sb.toString();

        }catch (Exception e){
            e.printStackTrace();}
        return null;
    }
}
