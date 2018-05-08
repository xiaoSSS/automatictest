package com.baizhitong.automatictest.web.core;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.core.dataprovider.DefaultDataProvider;
import com.baizhitong.automatictest.web.core.dataprovider.IDataProvider;
import com.baizhitong.automatictest.web.core.initialization.ITestSuitInitializer;
import com.baizhitong.automatictest.web.core.initialization.ymal.YamlTestSuitInitializer;
import com.baizhitong.automatictest.web.core.operation.DefaultTestSuitOperator;
import com.baizhitong.automatictest.web.core.operation.ITestSuitOperator;

/**
 * Created by wangsj on 2018/5/8.
 */
public class WebTestBootstrap {


    public static void main(String[] args){
        TestContext context = new TestContext();

        ITestSuitInitializer initializer = new YamlTestSuitInitializer();
        IDataProvider dataProvider = new DefaultDataProvider();
        ITestSuitOperator operator = new DefaultTestSuitOperator();

        initializer.init(context);      //初始化测试套件
        dataProvider.providerTestData(context);     //提供测试数据
        operator.operate(context);      //执行测试操作


    }
}
