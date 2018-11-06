package com.hanqi.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 自定义的日期参数转换器
 *
 * @author Administrator
 */
public class MyDate implements Converter<String, Date> {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");

    @Override
    public Date convert(String arg0) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(arg0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回当前月份的1号是周几
     *
     * @return
     */
    public static int getCurrMonthFirstDayWeek() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 返回指定月份的第一天是周几
     *
     * @param month
     * @return
     */
    public static int getMonthFirstDayWeek(int month) {
        if (month < 1 || month > 12) {
            throw new RuntimeException("请指定合适的月份 !");
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 返回当前月份
     *
     * @return
     */
    public static int getCurrMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回当前的年份
     *
     * @return
     */
    public static int getCurrYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回当前月是几号
     *
     * @return
     */
    public static int getCurrDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前的时间标识
     *
     * @return
     */
    public static String getDateStr() {
        return getDateStr(getCurrYear(), getCurrMonth(), getCurrDate());
    }

    /**
     * 获取指定的时间标识
     * @return
     */
    public static String getDateStr(int year, int month, int day) {
        return MyUtil.concat(year, month, day);
    }

    /**
     * 返回当前月份总共有多少天
     *
     * @return
     */
    public static int getCurrentMonthDays() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return getCurrentMonthDays(year, month);
    }

    /**
     * 返回当年的指定月份总共有多少天
     *
     * @param month
     * @return
     */
    public static int getCurrentMonthDays(int month) {
        if (month < 1 || month > 12) {
            throw new RuntimeException("请指定合适的月份 !");
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return getCurrentMonthDays(year, month);
    }

    /**
     * 返回指定年份和指定月份总共有多少天
     *
     * @param year
     * @param month
     * @return
     */
    public static int getCurrentMonthDays(int year, int month) {
        if (month < 1 || month > 12) {
            throw new RuntimeException("请指定合适的月份 !");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = simpleDateFormat.format(calendar.getTime());
        return Integer.parseInt(last);
    }
}
