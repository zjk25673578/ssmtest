package com.hanqi.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class TestDemo {
    public static String readHtml(String path) throws Exception {
/*        System.out.println(MyDate.getCurrMonth());
        System.out.println(MyDate.getCurrYear());
        System.out.println(MyDate.getCurrDate());
        System.out.println(MyDate.getDateStr());*/
        StringBuilder content = new StringBuilder();
        File file = new File(path);
        if (file.exists()) {
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                content.append(line);
            }
            br.close();
        } else {
            System.out.println("FILE NOT FOUND !");
        }
        return content.toString();
    }
}
