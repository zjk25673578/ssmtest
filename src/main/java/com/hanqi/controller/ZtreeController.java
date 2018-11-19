package com.hanqi.controller;

import com.alibaba.fastjson.JSON;
import com.hanqi.service.ZtreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ztree")
public class ZtreeController {

    @Autowired
    private ZtreeService ztreeService;


    @RequestMapping("/main")
    public String main() {
        return "page/ztree/main";
    }

    @RequestMapping("/left/main")
    public String menuMain() {
        return "page/ztree/left/main";
    }

    @ResponseBody
    @RequestMapping("/getSysmenuData")
    public String getSysmenuData() {
        return JSON.toJSONString(ztreeService.trees());
    }
}
