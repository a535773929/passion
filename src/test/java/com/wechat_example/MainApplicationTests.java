package com.wechat_example;


import com.wechat_example.api.UploadFiles;
import com.wechat_example.entity.*;
import com.wechat_example.service.WxService;
import com.wechat_example.test.Chinese;
import com.wechat_example.test.City;
import com.wechat_example.test.ParameterBinding;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.wechat_example.service.WxService.getUserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest

@Component
public class MainApplicationTests{


    @Test
    public void testToken(){
        System.out.println(WxService.getAccessToken());
    }
    @Test
    public void testButton(){
        //菜单对象
        Button btn = new Button();
        //第一个一级菜单（点击）
        btn.getButton().add(new ClickButton("啦啦啦啦","111"));
        //第二个一级菜单（url跳转）
        btn.getButton().add(new ViewButton("百度","www.baidu.com"));
        //第三个子菜单
        SubButton sb = new SubButton("有子菜单");
        sb.getSub_button().add(new ViewButton("京东","www.jd.com"));
        sb.getSub_button().add(new ClickButton("二级菜单","222"));
        //子菜单加入一级菜单
        btn.getButton().add(sb);

        //button转为json
        JSONObject jsonObject = JSONObject.fromObject(btn);
        System.out.println(jsonObject.toString());

    }
    @Test
    public void  testSuper(){
        City c=new City();
        c.value();
    }
    @Test
    public void  testSuper2(){
        Chinese cn = new Chinese();
        cn = new Chinese("codersai");
        cn = new Chinese("codersai", 18);
    }

    @Test
    public void testUpload() throws IOException {
        String file = "G:/workspace/lab413/wx_test_5/src/main/resources/static/1.jpg";
        String  result = UploadFiles.upload(file, "image");
        System.out.printf(result);


       // {"type":"image","media_id":"YUIiCvq9wBpCGpP-Uu76HVLkmBY4zazHBRzBePZbT9CnOigwlCKog9nOFCKI31zt","created_at":1544515155}

    }

    @Test
    public void testGetUserInfo(){
        String userInfo = getUserInfo("o5Slv5iEiAimoMS2h3kJBRzhY_NA");
        System.out.printf(userInfo);
       // {"subscribe":1,"openid":"o5Slv5iEiAimoMS2h3kJBRzhY_NA","nickname":"La Campanella","sex":1,"language":"zh_CN","city":"成都","province":"四川","country":"中国","headimgurl":"http:\/\/thirdwx.qlogo.cn\/mmopen\/R8icoMVs6SqPaF7YGk9ddFkRNnqCUwFsd7SVoniaBNfED1H7AKoia0YCTMT2uEQXxxedFxYbU1lRvkBXRtwkYveyI94zxiaWoJ6w\/132","subscribe_time":1544491919,"remark":"","groupid":0,"tagid_list":[],"subscribe_scene":"ADD_SCENE_QR_CODE","qr_scene":0,"qr_scene_str":""}
    }
    @Test

    public void testProperties(){
        ParameterBinding parameterBinding = new ParameterBinding();
        System.out.println(parameterBinding.appID);


    }
    @Test
    public void get_token(){
        String token = WxService.getAccessToken();
        System.out.println(token);
    }

}

