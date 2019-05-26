package com.nju.second.Service;


import com.nju.second.Dao.UserInfo;
import com.nju.second.Model.User;
import com.nju.second.Repositories.UserRepository;
import com.nju.second.Tools.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Service
public class userService {

    @Autowired
    UserRepository userRepository;

    public boolean Login(String userName,String password){
        try {
            User user = userRepository.findByUserName(userName);
            return user!=null && user.getPassWord().equals(password);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public int Register(String userName,String password){
        try {
            User user = userRepository.findByUserName(userName);
            if(user == null){
                User newUser = new User();
                newUser.setUserName(userName);
                newUser.setPassWord(password);
                newUser.setRegisterDate(TimeTools.getTime());
                newUser.setImagePath("default");
                userRepository.save(newUser);
                return 0;
            }else{
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }


    public int getIdByUsername(String userName){
        try {
            return userRepository.findByUserName(userName).getUserId();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    public UserInfo getUserInfoByID(int userid){
        UserInfo userInfo = new UserInfo();
        try {
            User user = userRepository.findByUserId(userid);
            String username = user.getUserName();
            String imagePath = user.getImagePath();
            InputStream in = null;
            byte[] data = null;
            //读取图片字节数组
            try
            {
                in = new FileInputStream(imagePath);
                data = new byte[in.available()];
                in.read(data);
                in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            //对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            String base64 = encoder.encode(data);
            int money = user.getMoney();
            userInfo.setAmount(money);
            userInfo.setBase64(base64);
            userInfo.setUsername(username);
            return userInfo;
        }catch (Exception e){
            e.printStackTrace();
            return userInfo;
        }

    }

    public int addMoney(int userid,int amount){
        try{
            User user = userRepository.findByUserId(userid);
            int money = user.getMoney();
            money += amount;
            user.setMoney(money);
            userRepository.save(user);
            return 0;
        }catch(Exception e){
            e.printStackTrace();
            return 1;
        }

    }

    public int getMoney(int userid) {
        try{
            User user = userRepository.findByUserId(userid);
            int money = user.getMoney();
            return money;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

//    public UserInfo getAchievement(int userId) {
//        try {
//            User user = userRepository.findByUserId(userid);
//            String username = user();
//            String imagePath = user.getImagePath();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return userInfo;
//        }
//    }
}
