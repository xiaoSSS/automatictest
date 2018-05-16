package com.baizhitong.automatictest.web.core.operation;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.bean.page.PageTask;

import java.util.Map;

/**
 * Created by wangsj on 2018/5/8.
 */
public interface ITaskOperator {

    void operate(PageTask task, Map elementData);
}
