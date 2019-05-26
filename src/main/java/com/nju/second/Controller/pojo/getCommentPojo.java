package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

public class getCommentPojo
{
    @Range(min = 1, message = "GameID错误")
    @NotBlank(message = validationMessage.blank)
    int gameID;



    public void setGameID(int gameID){
        this.gameID = gameID;
    }



    public int getGameID(){
        return gameID;
    }


}
