package com.nju.second.Model;

import com.nju.second.Repositories.AchievementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchievementInit {
    @Autowired
    AchievementRepo achievementRepo;
    public void init(){
        Achievements a1 = new Achievements();
        a1.setContent("通关成功一百次");
        a1.setName("百关达成");
        a1.setImgId(1001);
        achievementRepo.save(a1);

        Achievements a2 = new Achievements();
        a2.setContent("通关成功一千次");
        a2.setName("千关达成");
        a2.setImgId(1002);
        achievementRepo.save(a2);

        Achievements a3 = new Achievements();
        a3.setContent("通关成功一万次");
        a3.setName("万关达成");
        a3.setImgId(1003);
        achievementRepo.save(a3);

        Achievements a4 = new Achievements();
        a4.setContent("拥有零个好友");
        a4.setName("形单影只");
        a4.setImgId(1004);
        achievementRepo.save(a4);

        Achievements a5 = new Achievements();
        a5.setContent("拥有一个好友");
        a5.setName("路遇知音");
        a5.setImgId(1005);
        achievementRepo.save(a5);

        Achievements a6 = new Achievements();
        a6.setContent("拥有十个好友");
        a6.setName("呼朋引伴");
        a6.setImgId(1006);
        achievementRepo.save(a6);

        Achievements a7 = new Achievements();
        a7.setContent("拥有一百个好友");
        a7.setName("人尽皆知");
        a7.setImgId(1007);
        achievementRepo.save(a7);


    }
}
