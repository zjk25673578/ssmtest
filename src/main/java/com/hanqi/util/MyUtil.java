package com.hanqi.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtil extends StringUtils {

    /**
     * 将多个对象以字符串的形式拼接起来
     *
     * @param objs
     * @return
     */
    public static String concat(Object... objs) {
        Object[] objects = objs;
        if (objects == null || objects.length == 0) {
            return "";
        }
        String temp = "";
        for (Object o : objects) {
            if (o != null)
                temp += o;
        }
        return temp;
    }

    /**
     * 将List转换成Map, 以便于在页面显示
     *
     * @return
     */
    public static Map<String, Object> list2MapInfo(List<Map<String, Object>> mapList) {
        Map<String, Object> resultMap = new HashMap<>();
        for (Map<String, Object> map : mapList) {
            if (map != null) {
                Integer year = (Integer) map.get("year");
                Integer month = (Integer) map.get("month");
                Integer day = (Integer) map.get("day");
                String sign = concat(year, month, day);
                Object obj = map.get("attenname");
                if (obj != null) {
                    Object value = resultMap.get(sign);
                    if (value != null) {
                        resultMap.put(sign, obj + ", " + value);
                    } else {
                        resultMap.put(sign, obj);
                    }
                }
            }
        }
        return resultMap;
    }
}
