package com.baizhitong.automatictest.web.bean.page;

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

    private List<PageElement> elements = new ArrayList<PageElement>();

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

    public List<PageElement> getElements() {
        return elements;
    }

    public void setElements(List<PageElement> elements) {
        this.elements = elements;
    }

    public PageElement getElements(String id){
        return elements.stream().filter(
                element->element.getId().equals(id)
                ).findFirst().get();
    }
}
