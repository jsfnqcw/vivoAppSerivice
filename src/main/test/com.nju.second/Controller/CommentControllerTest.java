package com.nju.second.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nju.second.Controller.pojo.addCommentPojo;
import com.nju.second.Controller.pojo.getCommentPojo;
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

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test1() {
        try {
            addCommentPojo addCommentPojo = new addCommentPojo(12,"asd");
            mvc.perform(MockMvcRequestBuilders
                    .post("/addComment").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(addCommentPojo)));
//            .andExpect(MockMvcResultMatchers.content().string("FUCK"));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            getCommentPojo getCommentPojo = new getCommentPojo();
            getCommentPojo.setGameID(12);
            mvc.perform(MockMvcRequestBuilders
                    .post("/getComment").requestAttr("User",12).sessionAttr("User",12).contentType(MediaType.APPLICATION_JSON)
                    .content(JSON.toJSONString(getCommentPojo)));
//            .andExpect(MockMvcResultMatchers.content().string("FUCK"));  //测试接口返回内容
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}