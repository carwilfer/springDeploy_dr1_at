package com.infnet.springdeploy_dr1_at.service;

import com.infnet.springdeploy_dr1_at.model.Disciplina;
import com.infnet.springdeploy_dr1_at.model.Nota;
import com.infnet.springdeploy_dr1_at.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;

    public Nota salvar(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota buscarPorId(Long id) {
        return notaRepository.findById(id).orElse(null);
    }

    public Nota atualizar(Long id, Nota nota) {
        if (!notaRepository.existsById(id)) {
            return null;
        }
        nota.setId(id);
        return notaRepository.save(nota);
    }

    public void deletar(Long id) {
        notaRepository.deleteById(id);
    }

    public List<Nota> listarAprovados(Long disciplinaId) {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(disciplinaId);
        return notaRepository.findByDisciplinaAndValorGreaterThanEqual(disciplina, 7.0);
    }

    public List<Nota> listarReprovados(Long disciplinaId) {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(disciplinaId);
        return notaRepository.findByDisciplinaAndValorLessThan(disciplina, 7.0);
    }
}
