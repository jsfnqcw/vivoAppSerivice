package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class pagePojo {
    @Range(min = 1, message = "页数错误")
    @NotBlank(message = validationMessage.blank)
    int page;

    public pagePojo(int page){
        this.page = page;
    }

    public int getPage(){
        return page;
    }

    public void setPage(){
        this.page = page;
    }
}
