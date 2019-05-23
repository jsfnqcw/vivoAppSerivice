package com.nju.second.Controller.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class loginPojo {


    @Size(max=30, min=6 , message = validationMessage.not_enough_Length)
    @NotBlank(message = validationMessage.blank)
    String userName;

    @Size(max=30, min=6, message = validationMessage.not_enough_Length)
    @NotBlank(message = validationMessage.blank)
    String passWord;


    public loginPojo() {
    }

    public loginPojo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
