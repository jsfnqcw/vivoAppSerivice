package com.nju.second.Repositories;

import com.nju.second.Model.Game;
import com.nju.second.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    @Nullable
    Game findByGameId(int id);


}
