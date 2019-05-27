package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;

public class AchievementPojo {
    @Range(min = 1, message = "作者id错误")
    int userID;

    public AchievementPojo(int userID){
        this.userID = userID;
    }

    public int getUserID(){
        return userID;
    }

    public void setUserID(int userID){
        this.userID = userID;
    }
}
