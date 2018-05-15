package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuya
 * @author: liuya
 * Date: 2018/5/15
 * Time:  9:48
 * projectName:baseone
 */

@RestController
public class Controller {


    @RequestMapping("/hello")
    public String hello() {

        return "Hello World";
    }


}
