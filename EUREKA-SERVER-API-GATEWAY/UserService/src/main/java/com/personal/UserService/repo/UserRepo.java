package com.personal.UserService.repo;

import com.personal.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByProfession(String profession);
}
