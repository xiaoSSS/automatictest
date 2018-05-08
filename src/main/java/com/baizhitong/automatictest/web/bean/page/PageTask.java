package com.baizhitong.automatictest.web.bean.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsj on 2018/5/7.
 */
public class PageTask {

    private String id;

    private String operate;

    private String pageId;

    private List<String> elementIds;

    private PageObject pageObject;

    private List<PageElement> pageElements = new ArrayList<PageElement>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public PageObject getPageObject() {
        return pageObject;
    }

    public void setPageObject(PageObject pageObject) {
        this.pageObject = pageObject;
    }

    public List<PageElement> getPageElements() {
        return pageElements;
    }

    public void setPageElements(List<PageElement> pageElements) {
        this.pageElements = pageElements;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public List<String> getElementIds() {
        return elementIds;
    }

    public void setElementIds(List<String> elementIds) {
        this.elementIds = elementIds;
    }
}
