package com.hanqi.controller;

import com.hanqi.model.FormModel;
import com.hanqi.model.Message;
import com.hanqi.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class GlobalController {

    /**
     * 方法中@InitBinder对日期的转换规则可能比较严格
     * 比如: 2018-02-15 13:20:33对于yyyy-MM-dd形式会造成转换失败
     *
     * @param binder
     */
    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @InitBinder
    public void initBinder2(WebDataBinder binder) {
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @InitBinder
    public void initBinder3(WebDataBinder binder) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false); // false为严格匹配, true为宽松匹配, 比如2018-23-15会转换成2019-11-15
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }*/

    /*    @RequestMapping("/error404")
        public String error404() {
            return "jsp/404";
        }

        @RequestMapping("/error500")
        public String error500() {
            return "jsp/500";
        }*/

    /**
     * 跳转至表单页面
     *
     * @return
     */
    @RequestMapping("/datetime/test")
    public String index() {
        return "page/datetime/test";
    }

    /* ==============================只有Date参数============================== */

    /**
     * 页面跳转接收日期类型的参数
     * 配置转换器(springmvc的配置文件)
     * 或者上面的@InitBinder注解修饰的方法, 上面的方法会覆盖日期转换器
     * 但是上面方法中如果转换失败的话, 还是会抛出 400异常
     * 如果啥都没有, 抛出 400 异常
     * InitBinder注解的方法执行顺序
     * 先执行方法名为initBinder的方法
     * 其他按照定义的顺序来(瞎逼试的, 没有任何根据, 如果总结的不对, 我也没有办法)
     *
     * @param dateParam
     * @param model
     * @return
     */
    @RequestMapping("/datetime/formDate")
    public String formDate(Date dateParam, Model model) {
        setModel(dateParam, model);
        return "page/datetime/success";
    }

    /**
     * 同上
     *
     * @param dateParam
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/datetime/formDateAjax")
    public Message formDateAjax(Date dateParam, Model model) {
        setModel(dateParam, model);
        if (dateParam != null) {
            return MyUtil.msg(1, "接收成功 !");
        }
        return MyUtil.msg(-1, "接收失败 !");
    }











    /* ==============================实体类============================== */

    /**
     * 配置日期转换器, 实体类中所有的Date类型的参数都会经过日期转换器转换一下
     * 页面跳转可以让List和Array都能接收到所有的参数
     * 同样, 如果啥都没有, 也是抛出 400 异常
     *
     * @param formModel
     * @param model
     * @return
     */
    @RequestMapping("/datetime/formMvc")
    public String formMvc(FormModel formModel, Model model) {
        setModel(formModel, model);
        return "page/datetime/success";
    }

    /**
     * ajax接收实体类参数时, Array或者List参数会有问题, 只会接收到最后一个(这时候就需要用@RequestBody来接收, 下面再说)
     * 配置日期转换器同样也是所有的Date都会经过转换器
     * 如果同样也配置了@InitBinder的方法, 转换器会失效, 并且如果@InitBinder的方法转换失败, 同样会抛出 400异常
     * 如果@InitBinder修饰的方法中没有指明Array或者List的处理, 仍然只接收最后一个
     *
     * @param formModel
     * @return
     */
    @ResponseBody
    @RequestMapping("/datetime/formAjax")
    public Message formAjax(FormModel formModel) {
        System.out.println("formAjax -> " + formModel);
        if (formModel != null) {
            return MyUtil.msg(1, "接收成功 !");
        }
        return MyUtil.msg(-1, "接收失败 !");
    }

    /**
     * 没有日期转换器, @InitBinder的方法时, JSONObject可以接收到所有的参数,
     * 但都是以字符串的形式接收, 前端发送的List, Array参数都是接收最后一个
     *
     * @param formModel
     * @return
     */
    @ResponseBody
    @RequestMapping("/datetime/formAjaxJson")
    // public Message formAjaxJson(@RequestBody(required = false) JSONObject formModel) {
    public Message formAjaxJson(@RequestBody(required = false) FormModel formModel) {
        System.out.println("formAjaxJson -> " + formModel);
        if (formModel != null) {
            return MyUtil.msg(1, "接收成功 !");
        }
        return MyUtil.msg(-1, "接收失败 !");
    }
















    private void setModel(FormModel formModel, Model model) {
        System.out.println(formModel);
        if (formModel != null) {
            model.addAttribute("color", "green");
            model.addAttribute("msg", "接收成功 !");
        } else {
            model.addAttribute("color", "red");
            model.addAttribute("msg", "接收失败 !");
        }
    }

    private void setModel(Date flag, Model model) {
        System.out.println("接收到的日期参数: " + flag);
        if (flag != null) {
            model.addAttribute("color", "green");
            model.addAttribute("msg", "接收成功 !");
        } else {
            model.addAttribute("color", "red");
            model.addAttribute("msg", "接收失败 !");
        }
    }
}
