package com.wechat_example.pojo;

import org.springframework.context.annotation.Bean;


public class AccessToken {
    private String access_token;//获取到的凭证

    private long expireTime;//凭证有效时间

    public long getExpiresTime() {
        return expireTime;
    }

    public void setExpiresTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public AccessToken(String access_token,String expireIn){
        this.access_token = access_token;
        this.expireTime = System.currentTimeMillis()+Integer.parseInt(expireIn)*1000;
    }
    public boolean isExpired(){
        return System.currentTimeMillis()>expireTime;
    }


}
