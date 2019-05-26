package com.nju.second.Repositories;

import com.nju.second.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Nullable
    User findByUserId (Integer id);

    @Nullable
    User findByUserName (String userName);





}
