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

    public String Register(String userName,String password){
        try {
            User user = userRepository.findByUserName(userName);
            if(user == null){
                User newUser = new User();
                newUser.setUserName(userName);
                newUser.setPassWord(password);
                newUser.setRegisterDate(TimeTools.getTime());
                newUser.setState(1);
                userRepository.save(newUser);
                return Message.Success;
            }else{
                return "userName is already used";
            }
        }catch (Exception e){
            e.printStackTrace();
            return Message.ServerError;
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






    public void example(){
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean example2(){
        try {

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
