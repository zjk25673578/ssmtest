package com.hanqi.test;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;

public class TestDemo {
    public static void main(String[] args) throws Exception {
/*        System.out.println(MyDate.getCurrMonth());
        System.out.println(MyDate.getCurrYear());
        System.out.println(MyDate.getCurrDate());
        System.out.println(MyDate.getDateStr());*/

        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("e:/aaaa/create_table.docx"));

        //添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        //设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText("我的事项");
        titleParagraphRun.setColor("000000");
        titleParagraphRun.setFontSize(20);


        //段落
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun run = firstParagraph.createRun();
        run.setText("\r");
//        run.setColor("696969");
//        run.setFontSize(16);

        //设置段落背景颜色
//        CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
//        cTShd.setVal(STShd.CLEAR);
//        cTShd.setFill("97FFFF");


        //换行
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun paragraphRun1 = paragraph1.createRun();
        paragraphRun1.setText("\r");


        //基本信息表格
        XWPFTable infoTable = document.createTable();
        //去表格边框
        // infoTable.getCTTbl().getTblPr().unsetTblBorders();

        XWPFTableRow row1 = infoTable.getRow(0);
        row1.setHeight(80);
        XWPFTableCell row1cell1 = row1.createCell();
        row1cell1.setText("事项主题：");
        XWPFTableCell row1cell2 = row1.createCell();
        row1cell2.setText("内容内容内容");
        XWPFTableCell row1cell3 = row1.createCell();
        row1cell3.setText("事项类型：");
        XWPFTableCell row1cell4 = row1.createCell();
        row1cell4.setText("内容内容内容");

        //列宽自动分割
//        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
//        infoTableWidth.setType(STTblWidth.DXA);
//        infoTableWidth.setW(BigInteger.valueOf(9072));

/*        //表格第一行
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("事项主题：");
        infoTableRowOne.addNewTableCell().setText("内容内容内容");
        infoTableRowOne.addNewTableCell().setText("事项类型：");
        infoTableRowOne.addNewTableCell().setText("内容内容内容");

        //表格第二行
        XWPFTableRow infoTableRowTwo = infoTable.createRow();
        infoTableRowTwo.getCell(0).setText("执行人：");
        infoTableRowTwo.getCell(1).setText("内容内容内容内容内容内内容内容内容内容");

        //表格第三行
        XWPFTableRow infoTableRowThree = infoTable.createRow();
        infoTableRowThree.getCell(0).setText("事项内容：");
        infoTableRowThree.getCell(1).setText("内容内容内容内容内内容内容内容内容内容内容内容内容内");

        //表格第四行
        XWPFTableRow infoTableRowFour = infoTable.createRow();
        infoTableRowFour.getCell(0).setText("备注：");
        infoTableRowFour.getCell(1).setText("是的各色个黑色核辐射人家双方当事人挺好");

        //表格第五行
        XWPFTableRow infoTableRowFive = infoTable.createRow();
        infoTableRowFive.getCell(0).setText("附件：");
        infoTableRowFive.getCell(1).setText("呵呵呵");*/

/*        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);*/

/*        //添加页眉
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        String headerText = "Java POI create MS word file.";
        ctHeader.setStringValue(headerText);
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);

        //设置为右对齐
        headerParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);

        //添加页脚
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();
        String footerText = "http://blog.csdn.net/zhouseawater";
        ctFooter.setStringValue(footerText);
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
        headerParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);*/

        document.write(out);
        out.close();
        System.out.println("OK !");

/*        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);

        byte[] result = baos.toByteArray();
        System.out.println(Arrays.toString(result));*/

/*
        File file = new File("E:\\aaaa\\1.txt");
        try {
            InputStream in = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int r;
            while ((r = in.read(buffer)) != -1) {
                baos.write(buffer);
                System.out.println(r);
            }
            byte[] result = baos.toByteArray();
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
}
