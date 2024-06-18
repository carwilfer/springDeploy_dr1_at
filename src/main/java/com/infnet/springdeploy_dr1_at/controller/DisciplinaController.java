package com.infnet.springdeploy_dr1_at.controller;

import com.infnet.springdeploy_dr1_at.model.Disciplina;
import com.infnet.springdeploy_dr1_at.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public Disciplina salvar(@RequestBody Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
    }

    @GetMapping
    public List<Disciplina> listarTodas() {
        return disciplinaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Disciplina buscarPorId(@PathVariable Long id) {
        return disciplinaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        return disciplinaService.atualizar(id, disciplina);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        disciplinaService.deletar(id);
    }
}
