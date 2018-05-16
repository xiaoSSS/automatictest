package com.baizhitong.automatictest.web.core.dataprovider.yaml;

import com.baizhitong.automatictest.web.bean.context.TestContext;
import com.baizhitong.automatictest.web.bean.data.TestData;
import com.baizhitong.automatictest.web.core.dataprovider.IDataProvider;
import com.baizhitong.automatictest.web.utils.YamlFileUtils;
import org.ho.yaml.Yaml;

/**
 * Created by wangsj on 2018/5/15.
 */
public class YamlDataProvider implements IDataProvider{

    private static final String DATA_ROOT = "/data";

    @Override
    public void provideTestData(TestContext context) {
        YamlFileUtils.findYaml(DATA_ROOT,(f)->{
            try {
                TestData data = Yaml.loadType(f,TestData.class);
                context.addTestData(data);
            }catch (Exception ex){}
            return null;
        });
    }
}
