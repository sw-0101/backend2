package com.example.hackathon_0101.Repository;

import com.example.hackathon_0101.Entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
UserEntity findById(String id);
}

