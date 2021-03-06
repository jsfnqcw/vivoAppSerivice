package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class UserInfoPojo {
    @Range(min = 1, message = "用户ID错误")
    int userID;

    public UserInfoPojo(int userID){
        this.userID = userID;
    }

    public int getUserID(){
        return userID;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }
}
