package com.hanqi.controller;

import com.hanqi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController // ResponseBody + Controller
@Controller // ResponseBody + Controller
@RequestMapping("/tranc")
public class TestController {

    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping("/test")
    public String test1() {
        return "这个还没写, 想着点, 运行声明式事务, 就不要try catch";
    }
}
