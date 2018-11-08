package com.hanqi.test;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

public class TestWord2 {
    public static void main(String[] args) {
        String title = "测试标题";
        String text = "aaaaa测试内容测试内容测试内容测试内容测试内容";
        try {
            //word内容
            String content="<html><body>" +
                    "<p style=\"text-align: center;\"><span style=\"font-family: 黑体, SimHei; font-size: 14px;\">"
                    + title + "</span></p>" + text + "</body></html>";
            byte b[] = content.getBytes("GBK");  //这里是必须要设置编码的，不然导出中文就会乱码。
            ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中

            /*
             * 关键地方
             * 生成word格式 */
            POIFSFileSystem poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
            //输出文件
/*            request.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");//导出word格式
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    new String(title.getBytes("GB2312"),"iso8859-1") + ".doc");
            ServletOutputStream ostream = response.getOutputStream();*/
            FileOutputStream ostream = new FileOutputStream(new File("e:\\aaaa.doc"));
            poifs.writeFilesystem(ostream);
            bais.close();
            ostream.close();
            poifs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
