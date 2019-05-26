package com.nju.second.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
    public String getGameListByAuthor(@RequestBody @Validated AuthorPojo i, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "{}"; }

        int authorId = i.getAuthorID();
        List<Integer> list =  gService.getGameListByAuthor(authorId);
        return JSONArray.parseArray(JSON.toJSONString(list)).toJSONString();

    }

    @RequestMapping("/getGameList")
    @ResponseBody
    public String getGameList(@RequestBody @Validated pagePojo i, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "{}"; }


        int authorId = (int)request.getSession().getAttribute("User");
        List<Integer> list =  gService.getGameListByAuthor(authorId);

        return JSONArray.parseArray(JSON.toJSONString(list)).toJSONString();

    }
}
