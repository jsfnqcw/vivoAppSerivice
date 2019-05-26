package com.nju.second.Controller.pojo;

import com.nju.second.Controller.User;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class UserInfoPojo {
    @Range(min = 1, message = "用户ID错误")
    @NotBlank(message = validationMessage.blank)
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
