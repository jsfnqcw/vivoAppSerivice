package com.nju.second.Controller;

import com.nju.second.Controller.pojo.*;
import org.junit.Test;

import static org.junit.Assert.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void login() {
        try {
            loginPojo loginPojo = new loginPojo("username","password");
            mvc.perform(MockMvcRequestBuilders
                    .post("/login").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(loginPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void register() {
        try {
            loginPojo loginPojo = new loginPojo("username","password");
            mvc.perform(MockMvcRequestBuilders
                    .post("/register").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(loginPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addMoney() {
        try {
            amountPojo amountPojo = new amountPojo(12);
            mvc.perform(MockMvcRequestBuilders
                    .post("/addMoney").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(amountPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getMoney() {
        try {
            amountPojo amountPojo = new amountPojo(12);
            mvc.perform(MockMvcRequestBuilders
                    .post("/getMoney").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(amountPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getUserInfoByID() {
        try {
            UserInfoPojo UserInfoPojo = new UserInfoPojo(12);
            mvc.perform(MockMvcRequestBuilders
                    .post("/getUserInfoByID").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(UserInfoPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getAchievement() {
        try {
            AchievementPojo achievementPojo = new AchievementPojo(12);
            mvc.perform(MockMvcRequestBuilders
                    .post("/getAchievements").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(achievementPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void followUser() {
        try {
            followPojo followPojo = new followPojo(12);
            mvc.perform(MockMvcRequestBuilders
                    .post("/followUser").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(followPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void unFollowUser() {
        try {
            followPojo followPojo = new followPojo(12);
            mvc.perform(MockMvcRequestBuilders
                    .post("/unfollowUser").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(followPojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void findUserByName() {
        try {
            UserNamePojo UserNamePojo = new UserNamePojo("username");
            mvc.perform(MockMvcRequestBuilders
                    .post("/findUserByName").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(UserNamePojo)));
//            .andExpect(MockMvcResultMatchers.content().string(""));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void int_To_JSONString() {
    }
}