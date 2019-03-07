package com.wechat_example.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.wechat_example.util
 * @ClassName: ParsingXml
 * @Author: tyq
 * @Description: //解析xml数据包，返回键值对
 * @Version: 1.0
 */
public class ParseXml {
    public static Map<String, String> parseRequest(InputStream is) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(is);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for(Element e:elements){
                map.put(e.getName(),e.getStringValue());
            }
            return map;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
