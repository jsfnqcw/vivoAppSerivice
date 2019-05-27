package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;

public class UserNamePojo {
    @Range(min = 1, message = "作者id错误")
    String userName;

    public UserNamePojo(String username){
        this.userName = username;
    }

    public String getUserID(){
        return userName;
    }

    public void setUserID(String userName){
        this.userName = userName;
    }
}
