package com.nju.second.Controller;

import com.nju.second.Controller.pojo.AuthorPojo;
import com.nju.second.Controller.pojo.pagePojo;
import com.nju.second.Service.gameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Game {
    @Autowired
    gameService gService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/getGameListByAuthor")
    @ResponseBody
    public List<Integer> getGameListByAuthor(@RequestBody @Validated AuthorPojo i, BindingResult bindingResult) {
        List<Integer> list = new ArrayList<Integer>();
        if(bindingResult.hasErrors()){
            return list;
        }
        int authorId = i.getAuthorID();
        return gService.getGameListByAuthor(authorId);

    }

    @RequestMapping("/getGameList")
    @ResponseBody
    public List<Integer> getGameList(@RequestBody @Validated pagePojo i, BindingResult bindingResult) {
        List<Integer> list = new ArrayList<Integer>();
        if(bindingResult.hasErrors()){
            return list;
        }
        int page = i.getPage();
        return gService.getGameListByAuthor(0);

    }
}
