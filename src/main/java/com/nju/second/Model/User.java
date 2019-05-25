package com.nju.second.Model;


import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
public class User {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    int userId;

    String userName;


    @ColumnTransformer(
            read = "CAST(AES_DECRYPT(pass_word, '1') as char(1000))",
            write = "AES_ENCRYPT(?, '1')" )
    @Column(columnDefinition="varbinary(255)")
    String passWord;

    String registerDate;
    int state;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User(int userId, String userName, String passWord, String registerDate, int state) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.registerDate = registerDate;
        this.state = state;
    }

    public User() {
    }
}
