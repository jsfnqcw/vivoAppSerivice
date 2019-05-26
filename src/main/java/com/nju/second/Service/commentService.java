package com.nju.second.Service;

import com.nju.second.Model.Comment;
import com.nju.second.Model.Game;
import com.nju.second.Repositories.CommentRepository;
import com.nju.second.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    GameRepository gameRepository;

    public void addComment(int gameid,String comment,String userid){
        try {
            Game game = gameRepository.findByGameId(gameid);
            Comment comment1 = new Comment(comment,userid)
            game.getComments().add(comment);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
