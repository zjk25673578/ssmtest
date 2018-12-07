package com.hanqi.test;

import com.hanqi.util.quartz.QuartzUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDemo {

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(1544256060000L)));
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(1545840000000L)));
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(1544256060000L)));
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(1545840000000L)));
    }

    public static void main222222(String[] args) {
        try {
            QuartzUtil.startOneTimeSchedule(new Date(), "");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

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
