package com.wechat_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Package: com.wechat_example.controller
 * @ClassName: WebController
 * @Author: tyq
 * @Description: ${description}
 * @Version: 1.0
 */
@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String homepage(){
        return "index";
    }
}
