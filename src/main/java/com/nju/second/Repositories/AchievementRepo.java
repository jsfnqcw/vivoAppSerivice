package com.nju.second.Repositories;


import com.nju.second.Model.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;


@Repository
public interface AchievementRepo extends JpaRepository<Achievements, Integer> {

    @Nullable
    Achievements findAchievementsByAchievementId(int id);
}
