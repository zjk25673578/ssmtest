package com.hanqi.controller;

import com.alibaba.fastjson.JSON;
import com.hanqi.model.TreeModel;
import com.hanqi.service.SysmenuService;
import com.hanqi.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/elemtree")
public class SysmenuController {

    @Autowired
    private SysmenuService sysmenuService;

    @RequestMapping("/trees")
    public String trees() {
        List<TreeModel> result = sysmenuService.trees();
        String msg;
        if (result.size() <= 0) {
            msg = "没有数据";
        } else {
            msg = "返回数据成功 !";
        }
        Map<String, Object> r = MyUtil.layData(0, msg, result.size(), result);
        return JSON.toJSONString(r);
    }
}
