package com.hanqi.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义的日期参数转换器
 *
 * @author Administrator
 */
public class MyDateFormatUtil implements Converter<String, Date> {

    private static final SimpleDateFormat[] sdfs = {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
            new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yy/MM/dd"),
            new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒")
    };

    @Override
    public Date convert(String arg0) {
        System.out.println("日期转换器开始运行=======================" + arg0);
        int index = 1;
        for (SimpleDateFormat sdf : sdfs) {
            System.out.println("进行第" + index++ + "次转换");
            try {
                return sdf.parse(arg0);
            } catch (ParseException e) {
                System.out.println("格式: " + sdf.toPattern() + "算逑...抛出异常 !");
                // e.printStackTrace();
            }
        }
        return null;
    }

}
