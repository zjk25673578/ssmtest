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
        for (SimpleDateFormat sdf : sdfs) {
            try {
                return sdf.parse(arg0);
            } catch (ParseException e) {
                // e.printStackTrace();
            }
        }
        return null;
    }

}
