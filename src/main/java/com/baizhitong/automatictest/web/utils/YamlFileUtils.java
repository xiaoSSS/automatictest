package com.baizhitong.automatictest.web.utils;

import com.baizhitong.automatictest.web.core.initialization.yaml.YamlTestSuitInitializer;

import java.io.File;
import java.net.URL;
import java.util.function.Function;

/**
 * Created by wangsj on 2018/5/15.
 */
public class YamlFileUtils {

    public static void findYaml(File file, Function<File,?> function){
        if(file.isDirectory()){
            File[] subFiles = file.listFiles();
            for(File f:subFiles){
                findYaml(f,function);
            }
        }else{
            try {
                function.apply(file);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void findYaml(String filePath, Function<File,?> function){
        URL fileUrl = YamlTestSuitInitializer.class.getClassLoader().getResource(filePath);
        if(fileUrl == null) {
            fileUrl = YamlTestSuitInitializer.class.getResource(filePath);
        }
        File file = new File(fileUrl.getFile());
        findYaml(file,function);
    }
}
