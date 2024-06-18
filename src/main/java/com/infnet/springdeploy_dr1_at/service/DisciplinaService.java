package com.infnet.springdeploy_dr1_at.service;

import com.infnet.springdeploy_dr1_at.model.Disciplina;
import com.infnet.springdeploy_dr1_at.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina salvar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    public Disciplina atualizar(Long id, Disciplina disciplina) {
        if (!disciplinaRepository.existsById(id)) {
            return null;
        }
        disciplina.setId(id);
        return disciplinaRepository.save(disciplina);
    }

    public void deletar(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
