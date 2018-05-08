package com.baizhitong.automatictest.web.core.initialization;

import com.baizhitong.automatictest.web.bean.context.TestContext;

/**
 * Created by wangsj on 2018/5/8.
 */
public interface ITestSuitInitializer {

    void init(TestContext context);
}
