package com.baizhitong.automatictest.service.impl;

import com.baizhitong.automatictest.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * Created by wangsj on 2018/4/11.
 */
@Service
public class TestServiceImpl implements ITestService {

    public String test1() {
        return "test1";
    }
}
