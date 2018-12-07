package com.hanqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bootstrap/layout")
public class BootStrapController {

    @RequestMapping("/main")
    public String index() {
        return "page/bootstrap/main";
    }
}
