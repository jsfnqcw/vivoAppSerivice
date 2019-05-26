package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class AuthorPojo {
    @Range(min = 1, message = "作者id错误")
    @NotBlank(message = validationMessage.blank)
    int authorID;

    public AuthorPojo(int authorID){
        this.authorID = authorID;
    }

    public int getAuthorID(){
        return authorID;
    }

    public void setAuthorID(){
        this.authorID = authorID;
    }
}
