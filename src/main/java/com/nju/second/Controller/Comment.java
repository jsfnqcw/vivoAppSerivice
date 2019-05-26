package com.nju.second.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nju.second.Controller.pojo.addCommentPojo;
import com.nju.second.Controller.pojo.getCommentPojo;
import com.nju.second.Service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Comment {
    @Autowired
    commentService cService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/addComment")
    @ResponseBody
    public void addComment(@RequestBody @Validated addCommentPojo i, BindingResult bindingResult) {
        int gameId = i.getGameID();
        String comment = i.getContent();
        HttpSession session = request.getSession(false);
        int userId = (int)session.getAttribute("User");
        cService.addComment(gameId,comment,userId);
    }

    @RequestMapping("/getCommentList")
    @ResponseBody
    public String getCommentList(@RequestBody @Validated getCommentPojo i, BindingResult bindingResult) {
        int gameId = i.getGameID();
        HttpSession session = request.getSession(false);
        int userId = (int)session.getAttribute("User");
        List<com.nju.second.Model.Comment> list = cService.getCommentList(gameId);
        return JSONArray.parseArray(JSON.toJSONString(list)).toJSONString();
    }

}
