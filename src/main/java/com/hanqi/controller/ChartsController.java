package com.hanqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charts")
public class ChartsController {

    @RequestMapping("/topage")
    public String formCharts() {
        return "page/charts/page";
    }
}
