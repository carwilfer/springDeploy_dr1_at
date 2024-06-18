package com.infnet.springdeploy_dr1_at.controller;

import com.infnet.springdeploy_dr1_at.dto.NotaAprovadaDTO;
import com.infnet.springdeploy_dr1_at.model.Disciplina;
import com.infnet.springdeploy_dr1_at.model.Nota;
import com.infnet.springdeploy_dr1_at.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @PostMapping
    public Nota salvar(@RequestBody Nota nota) {
        return notaService.salvar(nota);
    }

    @GetMapping("/aprovados/{disciplinaId}")
    public ResponseEntity<List<NotaAprovadaDTO>> getNotasAprovados(@PathVariable Long disciplinaId) {
        List<Nota> notas = notaService.listarAprovados(disciplinaId);

        List<NotaAprovadaDTO> notasDTO = notas.stream().map(nota -> new NotaAprovadaDTO(
                nota.getId(),
                nota.getValor(),
                nota.getDisciplina().getNome(),
                nota.getAluno().getNome()
        )).collect(Collectors.toList());

        return ResponseEntity.ok(notasDTO);
    }

    @GetMapping("/reprovados/{disciplinaId}")
    public ResponseEntity<List<NotaAprovadaDTO>> getNotasReprovados(@PathVariable Long disciplinaId) {
        List<Nota> notas = notaService.listarReprovados(disciplinaId);

        List<NotaAprovadaDTO> notasDTO = notas.stream().map(nota -> new NotaAprovadaDTO(
                nota.getId(),
                nota.getValor(),
                nota.getDisciplina().getNome(),
                nota.getAluno().getNome()
        )).collect(Collectors.toList());

        return ResponseEntity.ok(notasDTO);
    }

    @GetMapping("/{id}")
    public Nota buscarPorId(@PathVariable Long id) {
        return notaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Nota atualizar(@PathVariable Long id, @RequestBody Nota nota) {
        return notaService.atualizar(id, nota);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        notaService.deletar(id);
    }
}
