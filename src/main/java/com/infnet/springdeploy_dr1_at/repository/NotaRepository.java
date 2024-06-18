package com.infnet.springdeploy_dr1_at.repository;

import com.infnet.springdeploy_dr1_at.model.Disciplina;
import com.infnet.springdeploy_dr1_at.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByDisciplinaAndValorGreaterThanEqual(Disciplina disciplina, Double valor);
    List<Nota> findByDisciplinaAndValorLessThan(Disciplina disciplina, Double valor);
}
