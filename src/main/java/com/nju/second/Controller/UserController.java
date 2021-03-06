package com.nju.second.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nju.second.Controller.pojo.UserInfoPojo;
import com.nju.second.Controller.pojo.amountPojo;
import com.nju.second.Controller.pojo.loginPojo;
import com.nju.second.Controller.pojo.UserInfo;
import com.nju.second.Model.User;
import com.nju.second.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    userService uService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody @Validated loginPojo i, BindingResult bindingResult , HttpServletResponse response) {
        JSONObject obj = new JSONObject();
        if(bindingResult.hasErrors()){
            obj.put("success",1);
            obj.put("userID",-1);
            return obj.toJSONString();
        }

        if(uService.Login(i.getUserName(),i.getPassWord())){
            HttpSession session = request.getSession(true);
            int Id = uService.getIdByUsername(i.getUserName());
                session.setAttribute("User", Id);
                obj.put("success",0);
                obj.put("userID",Id);
                obj.put("userID",Id);
                return obj.toJSONString();

        }else{
            obj.put("success",1);
            obj.put("userID",-1);
            return obj.toJSONString();
        }

    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestBody @Validated loginPojo i, BindingResult bindingResult ) {
        if(bindingResult.hasErrors()){
            return Int_To_JSONString(1);
        }
        String userName = i.getUserName();
        String passWord = i.getPassWord();

        return Int_To_JSONString(uService.Register(userName,passWord));
    }

    @RequestMapping("/addMoney")
    @ResponseBody
    public String addMoney(@RequestBody @Validated amountPojo i, BindingResult bindingResult ) {
        if(bindingResult.hasErrors()){
            return Int_To_JSONString(1);
        }
        int money = i.getAmount();
        HttpSession session = request.getSession(false);
        int userid = (int)session.getAttribute("User");
        return Int_To_JSONString(uService.addMoney(userid,money));

    }

    @RequestMapping("/getMoney")
    @ResponseBody
    public String getMoney() {
        HttpSession session = request.getSession(false);
        int userid = (int)session.getAttribute("User");
        return Int_To_JSONString(uService.getMoney(userid));
    }

    @RequestMapping("/getUserInfoByID")
    @ResponseBody
    public String getUserInfoByID(@RequestBody @Validated UserInfoPojo i, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "{}";
        }
        UserInfo info = uService.getUserInfoByID(i.getUserID()) ;
        return JSONObject.toJSONString(info);

    }


    @RequestMapping("/getAchievement")
    @ResponseBody
    public String getAchievement(@RequestBody String i) {
        if(i == null){
            return null;
        }
        JSONObject obj = JSON.parseObject(i);
        int userId = obj.getInteger("userID");

        List list = uService.getAchievements(userId);
        return JSONArray.parseArray(JSON.toJSONString(list)).toJSONString();
    }


    @RequestMapping("/followUser")
    @ResponseBody
    public String followUser(@RequestBody String i) {
        if(i == null){
            return null;
        }
        JSONObject obj = JSON.parseObject(i);
        int userId = obj.getInteger("userID");
        int myId = (int) request.getSession().getAttribute("User");

        JSONObject ob = new JSONObject();
        if(uService.follow(myId,userId)){
            ob.put("success",0);
            return ob.toJSONString();
        }else {
            ob.put("success",1);
            return ob.toJSONString();
        }
    }


    @RequestMapping("/unfollowUser")
    @ResponseBody
    public String unFollowUser(@RequestBody String i) {
        if(i == null){
            return null;
        }
        JSONObject obj = JSON.parseObject(i);
        int userId = obj.getInteger("userID");
        int myId = (int) request.getSession().getAttribute("User");

        JSONObject ob = new JSONObject();
        if(uService.unFollow(myId,userId)){
            ob.put("success",0);
            return ob.toJSONString();
        }else {
            ob.put("success",1);
            return ob.toJSONString();
        }

    }


    @RequestMapping("/findUserByName")
    @ResponseBody
    public String findUserByName(@RequestBody String i) {
        if(i == null){
            return null;
        }
        JSONObject obj = JSON.parseObject(i);
        String userName = obj.getString("userName");


        JSONObject ob = new JSONObject();
        User usr = uService.findUserByName(userName);
        ob.put("name",usr.getUserName());
        ob.put("userId",usr.getUserId());
        ob.put("img",usr.getImagePath());
        return ob.toJSONString();
    }



    @RequestMapping("/user/noLogin")
    @ResponseBody
    public String noLogin() {
        return "NO LOGIN!";
    }





    public String Int_To_JSONString(int i){
        JSONObject obj = new JSONObject();
        obj.put("success",i+"");
        return obj.toString();
    }



}
