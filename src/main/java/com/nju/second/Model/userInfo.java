package com.nju.second.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class userInfo {
    @Id
    int userId;

    String age;
    String sex;
    String nickName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public userInfo(int userId, String age, String sex, String nickName) {
        this.userId = userId;
        this.age = age;
        this.sex = sex;
        this.nickName = nickName;
    }

    public userInfo() {
    }
}
