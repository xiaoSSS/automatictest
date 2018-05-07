package com.baizhitong.automatictest.web.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsj on 2018/5/7.
 */
public class PageObject {

    private String id;

    private String url;

    private String title;

    private Map<String,PageElement> elements = new HashMap<String,PageElement>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, PageElement> getElements() {
        return elements;
    }

    public void setElements(Map<String, PageElement> elements) {
        this.elements = elements;
    }

    public PageElement getElement(String key){
        return elements.get(key);
    }
}
