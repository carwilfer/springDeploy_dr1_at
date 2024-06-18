package com.infnet.springdeploy_dr1_at.controllerTest;

import com.infnet.springdeploy_dr1_at.controller.DisciplinaController;
import com.infnet.springdeploy_dr1_at.model.Disciplina;
import com.infnet.springdeploy_dr1_at.service.DisciplinaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class DisciplinaControllerTest {

    @InjectMocks
    private DisciplinaController disciplinaController;

    @Mock
    private DisciplinaService disciplinaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvar() {
        Disciplina disciplina = new Disciplina();
        when(disciplinaService.salvar(any(Disciplina.class))).thenReturn(disciplina);

        Disciplina result = disciplinaController.salvar(disciplina);

        assertEquals(disciplina, result);
        verify(disciplinaService, times(1)).salvar(any(Disciplina.class));
    }

    @Test
    void testListarTodas() {
        List<Disciplina> disciplinas = Arrays.asList(new Disciplina(), new Disciplina());
        when(disciplinaService.listarTodas()).thenReturn(disciplinas);

        List<Disciplina> result = disciplinaController.listarTodas();

        assertEquals(disciplinas, result);
        verify(disciplinaService, times(1)).listarTodas();
    }

    @Test
    void testBuscarPorId() {
        Disciplina disciplina = new Disciplina();
        when(disciplinaService.buscarPorId(anyLong())).thenReturn(disciplina);

        Disciplina result = disciplinaController.buscarPorId(1L);

        assertEquals(disciplina, result);
        verify(disciplinaService, times(1)).buscarPorId(anyLong());
    }

    @Test
    void testAtualizar() {
        Disciplina disciplina = new Disciplina();
        when(disciplinaService.atualizar(anyLong(), any(Disciplina.class))).thenReturn(disciplina);

        Disciplina result = disciplinaController.atualizar(1L, disciplina);

        assertEquals(disciplina, result);
        verify(disciplinaService, times(1)).atualizar(anyLong(), any(Disciplina.class));
    }

    @Test
    void testDeletar() {
        doNothing().when(disciplinaService).deletar(anyLong());

        disciplinaController.deletar(1L);

        verify(disciplinaService, times(1)).deletar(anyLong());
    }
}
