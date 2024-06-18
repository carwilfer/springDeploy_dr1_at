package com.infnet.springdeploy_dr1_at.service;

import com.infnet.springdeploy_dr1_at.model.Professor;
import com.infnet.springdeploy_dr1_at.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor atualizar(Long id, Professor professor) {
        if (!professorRepository.existsById(id)) {
            return null;
        }
        professor.setId(id);
        return professorRepository.save(professor);
    }

    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }

    public Professor findByUsername(String username) {
        return professorRepository.findByUsername(username);
    }
}
