package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class addCommentPojo {
    @Range(min = 1, message = "GameID错误")
    int gameID;

    @NotBlank(message = validationMessage.blank)
    String content;

    public addCommentPojo(int gameID,String content){
        this.gameID = gameID;
        this.content = content;
    }

    public void setGameID(int gameID){
        this.gameID = gameID;
    }

    public void setContent(String content){
        this.content = content;
    }

    public int getGameID(){
        return gameID;
    }

    public String getContent(){
        return content;
    }
}
