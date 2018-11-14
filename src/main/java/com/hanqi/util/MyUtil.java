package com.hanqi.util;

import com.hanqi.model.Message;
import com.hanqi.model.Sysmenu;
import com.hanqi.model.TreeModel;
import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
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

    /**
     * 构建response消息模型
     *
     * @param result
     * @return
     */
    public static Message msg(int result) {
        Message msg;
        if (result > 0) {
            msg = new Message(true, "数据操作成功 !", 1);
        } else {
            msg = new Message(false, "操作失败 !", 5);
        }
        return msg;
    }

    /**
     * 用于将多个javabean转换成Map<String, Object><br>
     * 应当注意重复的key值
     * @param objects
     * @return
     * @throws Exception
     */
    public static Map<String, Object> bean2Map(Object... objects) throws Exception {
        Map<String, Object> _map = null;
        if (objects != null || objects.length > 0) {
            for (int i = 0; i < objects.length; i++) {
                if (_map == null) {
                    _map = transBean2Map(objects[i]);
                } else {
                    _map.putAll(transBean2Map(objects[i]));
                }
            }
        }
        return _map;
    }

    private static Map<String, Object> transBean2Map(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            // 过滤class属性
            // if (!key.equals("class")) { // 得到property对应的getter方法
            Method getter = property.getReadMethod();
            Object value = getter.invoke(obj);
            map.put(key, value);
            //  }
        }
        return map;
    }

    /**
     * 组装layui-data-table所需的数据格式
     *
     * @param code
     * @param msg
     * @param count
     * @param data
     * @return
     */
    public static Map<String, Object> layData(int code, String msg, int count, List<? extends Object> data) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        resultMap.put("count", count);
        resultMap.put("data", data);
        return resultMap;
    }

    /**
     * @param list 源数据
     * @param id   从哪一级的id开始
     * @return
     */
    public static List<TreeModel> convertMenuList(List<Sysmenu> list, Integer id) {
        List<TreeModel> treeList = new LinkedList<>();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Sysmenu sysmenu = list.get(i);
                if (sysmenu.getParentid() == id) {
                    TreeModel treeModel = new TreeModel(list.get(i));
                    List<TreeModel> temp = convertMenuList(list, treeModel.getIds());
                    treeModel.setChildren(temp);
                    treeList.add(treeModel);
                }
            }
        }
        return treeList;
    }
}
