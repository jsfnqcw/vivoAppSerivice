package com.nju.second.Controller;

import com.nju.second.Controller.pojo.loginPojo;
import com.nju.second.Service.Message;
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


@Controller
public class User {

    @Autowired
    userService uService;
    @Autowired
    HttpServletRequest request;


    @RequestMapping("/test")
    @ResponseBody
    public String getResExm() {
        return "NMSL!";
    }


    @RequestMapping("/show")
    @ResponseBody
    public String getResxm() {
        return "Hello World2";
    }


    @RequestMapping("/app/login")
    @ResponseBody
    public String login(@RequestBody @Validated loginPojo i, BindingResult bindingResult ,HttpServletResponse response) {
        if(bindingResult.hasErrors()){
            return Message.ParamError;
        }
        if(uService.Login(i.getUserName(),i.getPassWord())){
            HttpSession session = request.getSession(true);

            session.setAttribute("User",uService.getIdByUsername(i.getUserName()));

            /*
            String a = session.getId();
            response.addHeader("JSESSIONID",a);
            */

            return Message.Success;
        }else{
            return Message.Fail;
        }
    }

    @RequestMapping("/app/register")
    @ResponseBody
    public String register(@RequestBody @Validated loginPojo i, BindingResult bindingResult ) {
        if(bindingResult.hasErrors()){
            return Message.ParamError;
        }
        String userName = i.getUserName();
        String passWord = i.getPassWord();

        return uService.Register(userName,passWord);
    }


    @RequestMapping("/user/noLogin")
    @ResponseBody
    public String noLogin() {
        return "NO LOGIN!";
    }




}
