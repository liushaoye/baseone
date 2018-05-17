package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuya
 *
 * @author : liuya
 *         Date: 2018/5/16
 *         Time:  19:08
 *         projectName:thymeleaf
 */

@Controller
public class ThymeleafController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(ModelMap map) {
        map.addAttribute("host","http://www.cnblogs.com/liuyangfirst/");
        return "index";
    }

}
