package com.hanqi.controller;

import com.hanqi.service.MyOfficeService;
import com.hanqi.util.EditorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/office")
public class MyOfficeController {

    @Autowired
    private MyOfficeService myOfficeService;

    /**
     * 查看导出富文本样例页面
     *
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "page/export/main";
    }

    /**
     * 查看导出富文本样例页面
     *
     * @return
     */
    @RequestMapping("/test")
    public String viewTest() {
        return "page/export/test";
    }

    /**
     * 查看导出富文本样例页面
     *
     * @return
     */
    @RequestMapping("/exportRichText")
    public void exportRichText(HttpServletRequest request, HttpServletResponse response) {
        EditorUtil e = new EditorUtil();
        try {
            e.exportWord(request, response, "title", "");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    /**
     * POI导出docx
     *
     * @return
     */
    @RequestMapping("/poiword")
    public ResponseEntity<byte[]> createWordWithPOI() {
        byte[] wordArray = null;
        try {
            wordArray = myOfficeService.makeWord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        String fileName = "temp.docx";

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<>(wordArray, headers, HttpStatus.CREATED);
    }
}
