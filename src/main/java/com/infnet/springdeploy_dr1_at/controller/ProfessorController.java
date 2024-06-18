package com.infnet.springdeploy_dr1_at.controller;

import com.infnet.springdeploy_dr1_at.model.Professor;
import com.infnet.springdeploy_dr1_at.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public Professor salvar(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    @GetMapping
    public List<Professor> listarTodos() {
        return professorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Professor buscarPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody Professor professor) {
        return professorService.atualizar(id, professor);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        professorService.deletar(id);
    }
}
