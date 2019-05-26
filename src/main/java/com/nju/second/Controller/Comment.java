package com.nju.second.Controller;

import com.nju.second.Controller.pojo.addCommentPojo;
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

@Controller
public class Comment {
    @Autowired
    commentService cService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/addComment")
    @ResponseBody
    public void addComment(@RequestBody @Validated addCommentPojo i, BindingResult bindingResult) {
        int gameid = i.getGameID();
        String comment = i.getContent();
        HttpSession session = request.getSession(false);
        int userid = (int)session.getAttribute("User");
        cService.addComment(gameid,comment,userid);
    }

}
