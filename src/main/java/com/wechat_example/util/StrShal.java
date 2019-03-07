package com.wechat_example.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Package: com.wechat_example.util
 * @ClassName: StrShal
 * @Author: tyq
 * @Description: ${description}
 * @Version: 1.0
 */
public class StrShal {
    /**
     * 字符串进行shal加密
     *
     * @param str
     * @return
     */
    public static String shal(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
