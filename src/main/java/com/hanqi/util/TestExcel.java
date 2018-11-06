package com.hanqi.util;

import java.io.File;

public class TestExcel {
    public static void main(String[] args) {
        File file = new File("E:\\emps.xls");
        try {
            ExcelUtil.readExcel(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
