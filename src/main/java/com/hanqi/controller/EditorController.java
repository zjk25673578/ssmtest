package com.hanqi.controller;

import com.alibaba.fastjson.JSONObject;
import com.hanqi.util.FileNameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/editor")
public class EditorController {

    @RequestMapping("/main")
    public String main() {
        return "page/editor/main";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(MultipartFile file, String pre, HttpServletRequest request) {
        System.out.print("开始上传文件...");
        String fileName = file.getOriginalFilename();

        if (pre == null) {
            pre = "";
        }

        File parent = FileNameUtil.getParentFile(pre, request);

        boolean flag;
        if (!parent.exists()) {
            flag = parent.mkdirs();
        } else {
            flag = parent.exists();
        }

        File saveFile = null;

        String newFileName = FileNameUtil.getFileName(fileName);
        if (flag) {
            saveFile = new File(parent.getAbsolutePath() + File.separator + newFileName);
            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("上传结束 !");

        if (saveFile != null) {
            System.out.println(saveFile.getAbsolutePath());
        }

        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        result.put("code", 0);
        result.put("msg", "");
        data.put("src", (saveFile != null ? saveFile.getAbsolutePath() : ""));
        data.put("title", fileName);
        result.put("data", data);
        return result.toString();
    }
}
