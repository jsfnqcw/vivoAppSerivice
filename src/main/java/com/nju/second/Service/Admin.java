package com.nju.second.Service;


import com.nju.second.Model.Achievements;
import com.nju.second.Model.User;
import com.nju.second.Repositories.AchievementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Admin {
    @Autowired
    AchievementRepo achievementRepo;


    public void newAchievement(String description , int imgId){
        try{
            Achievements ac=  new Achievements();
            ac.setContent(description);
            ac.setImgId(imgId);
            achievementRepo.save(ac);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
