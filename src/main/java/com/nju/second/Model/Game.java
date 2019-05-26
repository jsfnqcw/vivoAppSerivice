package com.nju.second.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    int gameId;

    String Name;

    String description;
    String imgPath;

    String Tags;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    User user;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "game",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    List<Comment> comments;



    public Game() {
    }

    public Game(String name, String description, String imgPath, String tags) {
        Name = name;
        this.description = description;
        this.imgPath = imgPath;
        Tags = tags;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }
}
