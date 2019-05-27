package com.nju.second.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.second.Controller.pojo.AuthorPojo;
import com.nju.second.Controller.pojo.pagePojo;
import com.nju.second.Model.Game;
import com.nju.second.Service.gameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class GameController {
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

    @RequestMapping("/getGameList")//所有的列表
    @ResponseBody
    public String getGameList(@RequestBody @Validated pagePojo i, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){return "{}"; }

        List<Integer> list = gService.getAllGamesId();
        return JSONArray.parseArray(JSON.toJSONString(list)).toJSONString();
    }

    @RequestMapping("/getGameInfo")
    @ResponseBody
    public String getGameList(@RequestBody String  i) {
        if(i == null){return null;}
        JSONObject obj = JSON.parseObject(i);
        Game game = gService.getGameInfo(obj.getInteger("gameID"));

        JSONObject ob = new JSONObject();
        ob.put("title",game.getName());
        ob.put("Tags",game.getTags());
        ob.put("img",game.getImgPath());
        ob.put("description",game.getDescription());

        return ob.toJSONString();
    }


    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return JSON.toJSONString(gService.getAllGamesId());
    }

}
