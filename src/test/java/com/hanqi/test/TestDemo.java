package com.hanqi.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class TestDemo {
    public static void main(String[] args) throws Exception {
/*        System.out.println(MyDate.getCurrMonth());
        System.out.println(MyDate.getCurrYear());
        System.out.println(MyDate.getCurrDate());
        System.out.println(MyDate.getDateStr());*/

        File file = new File("E:\\mytest\\1\\a.html");

        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        String line = br.readLine();
        System.out.println(line);

        br.close();
    }
}
