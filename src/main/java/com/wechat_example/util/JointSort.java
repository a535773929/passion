package com.wechat_example.util;

import java.util.Arrays;

/**
 * @Package: com.wechat_example.util
 * @ClassName: JointSort
 * @Author: tyq
 * @Description: ${description}
 * @Version: 1.0
 */
public class JointSort {
    /**
     * 参数排序
     *
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }
        return sb.toString();
    }
}
