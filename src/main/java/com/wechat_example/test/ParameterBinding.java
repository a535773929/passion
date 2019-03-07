package com.wechat_example.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Package: com.wechat_example.test
 * @ClassName: ParameterBinding
 * @Author: tyq
 * @Description: ${description}
 * @Version: 1.0
 */
@Component
public class ParameterBinding {
    @Value("${abc}")
    public static String appID;
}
