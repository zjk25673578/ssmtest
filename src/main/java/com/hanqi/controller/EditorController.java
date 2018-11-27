package com.hanqi.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/editor")
public class EditorController {

    @RequestMapping("/main")
    public String main() {
        return "page/editor/main";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        String fileName = file.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String newName = new Date().getTime() + ext;
        String prefix = "files";
        String p = request.getServletContext().getRealPath(prefix);
//        String p = request.getServletContext().getRealPath(prefix);
        File uploadFile = new File(p + File.separator + newName);
        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(uploadFile);
            System.out.println(uploadFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        data.put("src", p + File.separator + newName);
        data.put("title", fileName);
        result.put("data", data);
        return result.toString();
    }
}
