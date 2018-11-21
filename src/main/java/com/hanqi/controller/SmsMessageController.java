package com.hanqi.controller;

import com.hanqi.util.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sms")
public class SmsMessageController {

    @ResponseBody
    @RequestMapping("/sendMsg")
    public String sendMsg() {
        HttpClientUtil client = HttpClientUtil.getInstance();

        //UTF发送
        //接口安全秘钥
        String key = "d41d8cd98f00b204e980";
        //用户名
        String uid = "zhaojk";
        //手机号码，多个号码如13800000000,13800000001,13800000002
        String smsMob = "15628952601,15106433491";
        //短信内容
        String smsText = "我是赵剑珂, 正在测试群发短信, 如果收到了忽略这个信息就好, 祝好 !";
        int result = client.sendMsgUtf8(uid, key, smsText, smsMob);
        if (result > 0) {
            return "UTF8成功发送条数==" + result;
        } else {
            return client.getErrorMsg(result);
        }
    }
}