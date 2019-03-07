package com.wechat_example.api;

import com.wechat_example.service.WxService;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

/**
 * @Package: com.wechat_example.api
 * @ClassName: UploadFiles
 * @Author: tyq
 * @Description: ${description}
 * @Version: 1.0
 */
public class UploadFiles {
    /*
     * @Method upload
     * @Author tyq
     * @Version  1.0
     * @Description
     * @* @param path  文件路径
     * @param type   文件类型
     * @Return java.lang.String
     */
    //上传文件

    public static String upload(String path,String type) throws IOException {
        File file = new File(path);
        String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
        url = url.replace("ACCESS_TOKEN", WxService.getAccessToken()).replace("TYPE", type);
        URL urlObj = new URL(url);
        //强转为https
        HttpsURLConnection cnn = (HttpsURLConnection)urlObj.openConnection();
        //设置连接信息
        cnn.setDoInput(true);
        cnn.setDoOutput(true);
        cnn.setUseCaches(false);
        //设置请求头信息
        cnn.setRequestProperty("Connection","Keep-Alive");
        cnn.setRequestProperty("Charset","utf8");
        //数据边界
        String boundary = "-----"+System.currentTimeMillis();
        cnn.setRequestProperty("Content-Type","multipart/form-data;boundary="+boundary);
        //获取输出流
        OutputStream out = cnn.getOutputStream();
        //创建输入流
        InputStream is = new FileInputStream(file);
        //准备数据
        //头部
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(boundary);
        sb.append("\r\n");
        sb.append("Content-Disposition:form-data;name=\"media\";filename=\"" + file.getName()+"\"\r\n");
        sb.append("Content-Type:application/octet-stream\r\n\r\n");
        out.write(sb.toString().getBytes());
//        System.out.printf(sb.toString());
        //文件内容
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b))!=-1){
            //从文件流写入输出流
            out.write(b,0,len);
        }
        //尾部
        String foot = "\r\n--" + boundary + "--\r\n";
        out.write(foot.getBytes());
        out.flush();
        out.close();
//        System.out.printf(foot.toString());
        //读数据
        InputStream is2 = cnn.getInputStream();
        StringBuilder resp = new StringBuilder();
        while ((len = is2.read(b))!=-1){
            //从输入流写入StringBuilder
            resp.append(new String(b,0,len));
        }
        return resp.toString();
    }
}
