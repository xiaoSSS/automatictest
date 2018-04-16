package com.baizhitong.automatictest;

import com.baizhitong.automatictest.action.TestAction;
import com.baizhitong.automatictest.service.ITestService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by wangsj on 2018/4/11.
 */
@Test
@ContextConfiguration(locations = {"classpath:application-web.xml"})
public class InterfaceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    ITestService testService;

    @Autowired
    TestAction testAction;

    @Test(groups = "interface")
    public void test1(){

        String res = testAction.test1();
        Assert.assertTrue("test1".equals(res));
    }
}
