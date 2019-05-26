package com.nju.second.Controller;

import com.nju.second.Controller.pojo.UserInfoPojo;
import com.nju.second.Controller.pojo.amountPojo;
import com.nju.second.Controller.pojo.loginPojo;
import com.nju.second.Dao.LoginMessage;
import com.nju.second.Dao.UserInfo;
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


    @RequestMapping("/login")
    @ResponseBody
    public LoginMessage login(@RequestBody @Validated loginPojo i, BindingResult bindingResult , HttpServletResponse response) {
        LoginMessage loginMessage = new LoginMessage();
        loginMessage.setSuccess(1);
        loginMessage.setUserID(-1);
        if(bindingResult.hasErrors()){
            return loginMessage;
        }
        if(uService.Login(i.getUserName(),i.getPassWord())){
            HttpSession session = request.getSession(true);
            int getIdByUserName = uService.getIdByUsername(i.getUserName());

            if(getIdByUserName==0){
                return loginMessage;
            }else {
                session.setAttribute("User", uService.getIdByUsername(i.getUserName()));
                loginMessage.setSuccess(0);
                loginMessage.setUserID(uService.getIdByUsername(i.getUserName()));
                return loginMessage;
            }
        }else{
            return loginMessage;
        }

    }

    @RequestMapping("/register")
    @ResponseBody
    public int register(@RequestBody @Validated loginPojo i, BindingResult bindingResult ) {
        if(bindingResult.hasErrors()){
            return 1;
        }
        String userName = i.getUserName();
        String passWord = i.getPassWord();

        return uService.Register(userName,passWord);
    }

    @RequestMapping("/addMoney")
    @ResponseBody
    public int addMoney(@RequestBody @Validated amountPojo i, BindingResult bindingResult ) {
        if(bindingResult.hasErrors()){
            return 1;
        }
        int money = i.getAmount();
        HttpSession session = request.getSession(true);
        int userid = (int)session.getAttribute("User");
        return uService.addMoney(userid,money);

    }

    @RequestMapping("/getMoney")
    @ResponseBody
    public int getMoney(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return 1;
        }
        HttpSession session = request.getSession(true);
        int userid = (int)session.getAttribute("User");
        return uService.getMoney(userid);

    }

    @RequestMapping("/getUserInfoByID")
    @ResponseBody
    public UserInfo getUserInfoByID(@RequestBody @Validated UserInfoPojo i, BindingResult bindingResult) {
        UserInfo userInfo = new UserInfo();
        if(bindingResult.hasErrors()){
            return userInfo;
        }
        HttpSession session = request.getSession(true);
        int userId = i.getUserID();
        return uService.getUserInfoByID(userId);

    }


    @RequestMapping("/user/noLogin")
    @ResponseBody
    public String noLogin() {
        return "NO LOGIN!";
    }




}
