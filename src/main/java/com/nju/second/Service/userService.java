package com.nju.second.Service;


import com.nju.second.Model.User;
import com.nju.second.Repositories.UserRepository;
import com.nju.second.Tools.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public int getUserInfoByID(int userid){
        try {
            User user = userRepository.findByUserId(userid);
            String username = user.getUserName();
            String img = user.getImagePath();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
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
}
