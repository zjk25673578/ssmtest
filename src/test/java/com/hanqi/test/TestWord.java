package com.hanqi.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestWord {


    public static void main(String[] args) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        try {
            configuration.setDefaultEncoding("utf-8");
            configuration.setDirectoryForTemplateLoading(new File("D:\\ideaspace\\ssmtest\\src\\main\\resources\\templet"));
            Template template = configuration.getTemplate("word2003.xml");
            Map<String, Object> map = new HashMap<>();
            map.put("otitle", "aaaaaaaaa");
            map.put("otype", "ccccc");
            map.put("sendtoName", "bbbbbbb");
            map.put("content", getImageBase());
            map.put("note", "eeeeeeeeeeeee");
            map.put("fileName", "fffffffff");
            Writer writer = new FileWriter("e:\\result.docx");

            template.process(map, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("完成 !");
    }

    //获得图片的base64码
    public static String getImageBase() {
        File file = new File("C:\\Users\\Administrator\\Desktop\\测试文件\\6.jpg");
        if (!file.exists()) {
            return "";
        }
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
