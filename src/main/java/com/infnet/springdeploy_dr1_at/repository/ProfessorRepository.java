package com.infnet.springdeploy_dr1_at.repository;

import com.infnet.springdeploy_dr1_at.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByUsername(String username);
}