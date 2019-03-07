package com.wechat_example.api;

import com.wechat_example.entity.Button;
import com.wechat_example.entity.ClickButton;
import com.wechat_example.entity.SubButton;
import com.wechat_example.entity.ViewButton;
import com.wechat_example.service.WxService;
import net.sf.json.JSONObject;

//创建菜单
public class CreateMenu {
    public static void main(String[] args){
        //菜单对象
        Button btn = new Button();
        //第一个菜单
        SubButton sb = new SubButton("关于我们");
        sb.getSub_button().add(new ViewButton("学校概况","http://uqgoxj7vh1.51http.tech/index"));
        sb.getSub_button().add(new ViewButton("新闻公告","http://www.jd.com"));
        sb.getSub_button().add(new ViewButton("招生信息","http://www.jd.com"));
        btn.getButton().add(sb);

        //第二个菜单
        SubButton sb2 = new SubButton("精品教育");
        sb2.getSub_button().add(new ViewButton("学历教育","http://lab413.free.idcfengye.com/index"));
        sb2.getSub_button().add(new ViewButton("网上课堂","http://www.jd.com"));
        sb2.getSub_button().add(new ViewButton("高端培训","http://www.jd.com"));
        btn.getButton().add(sb2);
        //第三个菜单
        SubButton sb3 = new SubButton("我的培深");
        sb3.getSub_button().add(new ViewButton("管理系统","http://www.jd.com"));
        sb3.getSub_button().add(new ViewButton("在线报名","http://www.jd.com"));
        sb3.getSub_button().add(new ClickButton("联系我们","contact"));
        //子菜单加入一级菜单
        btn.getButton().add(sb3);

        //button转为json
        JSONObject jsonObject = JSONObject.fromObject(btn);
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", WxService.getAccessToken());
        //发送请求
        System.out.println(jsonObject.toString());
        String result = WxPost.post(url,jsonObject.toString());
        System.out.printf(result);
    }
}
