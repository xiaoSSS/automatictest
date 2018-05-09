package com.baizhitong.automatictest.web.bean.page;

import com.baizhitong.automatictest.web.bean.context.TestContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsj on 2018/5/7.
 */
public class PageTask {

    private String id;

    private String validation;

    private String pageId;

    private List<String> elementIds;

    private List<TaskStep> steps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String operate) {
        this.validation = operate;
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

    public List<TaskStep> getSteps() {
        return steps;
    }

    public void initTaskStep(TestContext context){
        steps = new ArrayList<>();
        PageObject pageObject = context.getPageObject(pageId);
        if(pageObject!=null) {
            elementIds.stream().forEach(id -> {
                PageElement element = pageObject.getElements(id);
                if(element!=null) {
                    TaskStep step = new TaskStep(pageObject, element);
                }
            });
        }
    }


    public class TaskStep{

        private PageObject pageObject;

        private PageElement element;

        private TaskStep(PageObject pageObject,PageElement element){
            this.pageObject = pageObject;
            this.element = element;
        }

        public PageObject getPageObject() {
            return pageObject;
        }

        public PageElement getElement() {
            return element;
        }
    }

}
