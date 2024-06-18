package com.infnet.springdeploy_dr1_at.repository;

import com.infnet.springdeploy_dr1_at.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {}
