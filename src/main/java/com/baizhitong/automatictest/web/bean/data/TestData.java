package com.baizhitong.automatictest.web.bean.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsj on 2018/5/14.
 */
public class TestData {

    private static final String ASSERT_KEY="assert";

    String id;

    String taskId;

    List<Map<String,Object>> elementData = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public  List<Map<String,Object>> getElementData() {
        return elementData;
    }

    public void setElementData(List<Map<String,Object>> elementData) {
        this.elementData = elementData;
    }

    public Integer getCaseCount(){
        return elementData==null?0:elementData.size();
    }

}
