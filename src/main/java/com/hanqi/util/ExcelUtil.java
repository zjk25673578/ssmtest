package com.hanqi.util;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelUtil {

    private static ExcelListener excelListener = new ExcelListener();

    public static void readExcel(File file) throws Exception {
        InputStream inputStream = new FileInputStream(file);
        String extens = file.getName().substring(file.getName().lastIndexOf('.') + 1);
        System.out.println("文件的后缀名: " + extens);
        ExcelReader excelReader = null;
        if ("xls".equalsIgnoreCase(extens)) {
            excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, excelListener);
        }
        if ("xlsx".equalsIgnoreCase(extens)) {
            excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, excelListener);
        }
        if (excelReader != null) {
            excelReader.read();
        }
    }
}
