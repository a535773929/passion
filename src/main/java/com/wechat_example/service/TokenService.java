package com.wechat_example.service;

import com.wechat_example.util.JointSort;
import com.wechat_example.util.StrShal;

import javax.servlet.http.HttpServletRequest;


/**
 * @Package: com.wechat_example.service
 * @ClassName: TokenService
 * @Author: tyq
 * @Description: ${description}
 * @Version: 1.0
 */

public class TokenService {
    private final String TOKEN = "mrtang";

    public boolean tokenValidate(HttpServletRequest request) {

        System.out.println("getaaaaaaaaaaaaaaaaa");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce"); //随机数
        String echostr = request.getParameter("echostr");//随机字符串

        /**
         * 将token、timestamp、nonce三个参数进行字典序排序
         * 并拼接为一个字符串
         */
        String sortStr = JointSort.sort(TOKEN, timestamp, nonce);
        /**
         * 字符串进行shal加密
         */
        String mySignature = StrShal.shal(sortStr);
        /**
         * 校验微信服务器传递过来的签名 和  加密后的字符串是否一致, 若一致则签名通过
         */
        if (!"".equals(signature) && !"".equals(mySignature) && signature.equals(mySignature)) {
            System.out.println("-----签名校验通过-----");
            return true;
        } else {
            return false;
        }
    }


}
