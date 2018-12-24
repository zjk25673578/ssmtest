package com.hanqi.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 文件名处理工具类
 */
public class FileNameUtil {

    /**
     * 获取一个文件名的扩展名, 文件名两边空格将被忽略
     *
     * @param fileName null返回"", {""}返回"", {.xxx}返回"", {xxx.}返回""
     * @return
     */
    public static String getExtensionName(String fileName) {
        if (fileName == null) {
            return "";
        }
        fileName = fileName.trim();
        int idx = fileName.lastIndexOf('.');
        if (fileName.length() == 0 || idx <= 0) {
            return "";
        }
        if (idx != fileName.length() - 1) {
            return fileName.substring(fileName.lastIndexOf('.'));
        }
        return "";
    }

    /**
     * 获取一个文件名(不带扩展名)
     * @return
     */
    public static String getFileName() {
        return yearMonthDate() + '-' + uuid();
    }

    /**
     * 获取一个文件名(带扩展名)
     * @return
     */
    public static String getFileName(String fileName) {
        return yearMonthDate() + '-' + uuid() + getExtensionName(fileName);

    }

    /**
     * 全球唯一标示
     * @return
     */
    private static String uuid() {
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     *
     * @return
     */
    public static String yearMonthDate(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     *
     * @return
     */
    public static String yearMonthDate() {
        return yearMonthDate("yyyyMMdd");
    }

    public static File getParentFile(String pre, HttpServletRequest request) {
        return new File(request.getServletContext().getRealPath("/") + "files/" + pre);
    }
}
