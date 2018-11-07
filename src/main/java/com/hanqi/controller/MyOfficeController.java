package com.hanqi.controller;

import com.hanqi.service.MyOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/office")
public class MyOfficeController {

    @Autowired
    private MyOfficeService myOfficeService;

    /**
     * 随机抽取一名用户在当月的考勤信息导出成word
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
        ResponseEntity<byte[]> r = new ResponseEntity<>(wordArray,
                headers, HttpStatus.CREATED);
        return r;
    }

}
