package com.infnet.springdeploy_dr1_at.service;

import com.infnet.springdeploy_dr1_at.model.Aluno;
import com.infnet.springdeploy_dr1_at.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno atualizar(Long id, Aluno aluno) {
        if (!alunoRepository.existsById(id)) {
            return null;
        }
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }
}
