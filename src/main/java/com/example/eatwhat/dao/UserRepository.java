package com.example.eatwhat.dao;

import com.example.eatwhat.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
