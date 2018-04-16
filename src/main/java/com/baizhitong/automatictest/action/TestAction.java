package com.baizhitong.automatictest.action;

import com.baizhitong.automatictest.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangsj on 2018/4/11.
 */
@Controller
@RequestMapping("/test")
public class TestAction {

    @Autowired
    ITestService service;

    @RequestMapping("/t1")
    public String test1(){
        return service.test1();
    }
}
