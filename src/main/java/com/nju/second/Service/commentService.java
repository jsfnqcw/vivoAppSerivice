package com.nju.second.Service;

import com.nju.second.Model.Comment;
import com.nju.second.Model.Game;
import com.nju.second.Repositories.CommentRepository;
import com.nju.second.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    GameRepository gameRepository;

    public void addComment(int gameid,String comment,int userid){
        try {
            Game game = gameRepository.findByGameId(gameid);
            Comment com = new Comment();
            com.setContent(comment);
            com.setUserId(userid);
            com.setGame(game);
            com.setFloor(game.getComments().size()+1);
            commentRepository.save(com);
            game.getComments().add(com);
            gameRepository.save(game);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Comment> getCommentList(int gameid) {
        Game game = gameRepository.findByGameId(gameid);
        return game.getComments();
    }
}
