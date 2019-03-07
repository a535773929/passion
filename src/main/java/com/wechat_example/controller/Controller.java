package com.wechat_example.controller;


import com.wechat_example.service.TokenService;
import com.wechat_example.service.WxService;
import com.wechat_example.util.ParseXml;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

@RestController
public class Controller {

    @RequestMapping(value = "/wx",method = RequestMethod.GET)
    public void doget(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TokenService tokenService = new TokenService();
        boolean result = tokenService.tokenValidate(request);
        if (result){
            System.out.println("-----签名校验通过-----");
//            验证通过，返回微信发来的随机数
            response.getWriter().write(request.getParameter("echostr"));
        }else{
            System.out.println("-----签名校验失败-----");

        }
    }
    @RequestMapping(value = "/wx",method=RequestMethod.POST)
    public void dopost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        Map<String,String> requestMap = ParseXml.parseRequest(request.getInputStream());
//        打印接收到的xml数据包
        System.out.println("接收到消息："+requestMap);
        String respXml = WxService.getResponse(requestMap);
        PrintWriter out = response.getWriter();
        out.print(respXml);
        System.out.println("成功回复："+respXml);
        out.flush();
        out.close();
    }

}

