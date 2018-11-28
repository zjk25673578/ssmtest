package com.hanqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ckplayer")
public class CKPlayerController {

    @RequestMapping("/main")
    public String main() {
        return "page/ckplayer/main";
    }
}
