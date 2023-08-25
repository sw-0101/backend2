package com.example.hackathon_0101.Repository;

import com.example.hackathon_0101.Entity.PaperEntity;
import com.example.hackathon_0101.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<PaperEntity, Long> {
}
