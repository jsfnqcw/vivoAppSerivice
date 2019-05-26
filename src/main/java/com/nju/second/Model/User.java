package com.nju.second.Model;


import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.List;

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

    String imagePath;

    int money;




    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    List<Game> creationList;


    String focus;  //所有关注者的ID

    String achievements;  //所有成就整合的字符串





    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

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



    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Game> getCreationList() {
        return creationList;
    }

    public void setCreationList(List<Game> creationList) {
        this.creationList = creationList;
    }
    public User() {
    }
}
