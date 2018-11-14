package com.hanqi.controller;

import com.alibaba.fastjson.JSON;
import com.hanqi.model.Emp;
import com.hanqi.model.EmpSearchEntity;
import com.hanqi.model.Message;
import com.hanqi.service.EmpService;
import com.hanqi.util.MyUtil;
import com.hanqi.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/main")
    public String main() {
        return "page/emps/main";
    }

    @ResponseBody
    @RequestMapping("/saveOrUpdateEmp")
    public String addEmp(Emp emp) {
        int result;
        if(emp.getEmpno() == null) {
            result = empService.insertEmp(emp);
        } else {
            result = empService.updateEmp(emp);
        }
        Message msg = MyUtil.msg(result);
        return msg.toString();
    }

    @ResponseBody
    @RequestMapping("/deleteEmp")
    public String deleteEmp(Integer empno) {
        int result = empService.deleteEmp(empno);
        Message msg = MyUtil.msg(result);
        return msg.toString();
    }

    @ResponseBody
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "10") int limit, String key) {
        PageBean pageBean = new PageBean(limit, page);
        EmpSearchEntity empSearchEntity = JSON.parseObject(key, EmpSearchEntity.class);
        Map<String, Object> resultMap = empService.selectEmps(empSearchEntity, pageBean);
        return JSON.toJSONString(resultMap);
    }

    @ResponseBody
    @RequestMapping("/delMultipleEmp")
    public String delMultipleEmp(String ids) {
        int result = empService.delMultipleEmp(ids);
        Message msg = MyUtil.msg(result);
        return msg.toString();
    }
}
