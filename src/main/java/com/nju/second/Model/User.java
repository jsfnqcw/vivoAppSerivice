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

    String registerDate;
    String imagePath;

    int money;


    public List<Game> getCreationList() {
        return creationList;
    }

    public void setCreationList(List<Game> creationList) {
        this.creationList = creationList;
    }

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    List<Game> creationList;//文章列表


    String focus;  //所有关注者的ID

    public User(String userName, String passWord, String registerDate, String imagePath, int money) {
        this.userName = userName;
        this.passWord = passWord;
        this.registerDate = registerDate;
        this.imagePath = imagePath;
        this.money = money;
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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public User() {
    }
}
