package com.wechat_example.util;

import com.thoughtworks.xstream.XStream;
import com.wechat_example.entity.BaseMessage;
import com.wechat_example.entity.TextMessage;

/**
 * @Package: com.wechat_example.util
 * @ClassName: BeanToXml
 * @Author: tyq
 * @Description: 将数据对象转换成xml（只添加了文本消息）
 * @Version: 1.0
 */
public class BeanToXml {
    public static String beanToXml(BaseMessage msg) {
        XStream stream = new XStream();
        stream.processAnnotations(TextMessage.class);
        String xml = stream.toXML(msg);
        return xml;
    }
}
