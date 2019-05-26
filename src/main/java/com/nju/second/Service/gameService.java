package com.nju.second.Service;

import com.nju.second.Model.Game;
import com.nju.second.Model.User;
import com.nju.second.Repositories.CommentRepository;
import com.nju.second.Repositories.GameRepository;
import com.nju.second.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class gameService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    UserRepository userRepository;


    public List<Integer> getGameListByAuthor(int authorID){
        User user = userRepository.findByUserId(authorID);
        List<Game> gamelist = user.getCreationList();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<gamelist.size();i++){
            list.add(gamelist.get(i).getGameId());
        }
        return list;
    }


}
