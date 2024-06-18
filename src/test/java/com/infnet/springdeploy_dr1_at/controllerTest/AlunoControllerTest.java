package com.infnet.springdeploy_dr1_at.controllerTest;

import com.infnet.springdeploy_dr1_at.controller.AlunoController;
import com.infnet.springdeploy_dr1_at.model.Aluno;
import com.infnet.springdeploy_dr1_at.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class AlunoControllerTest {

    @InjectMocks
    private AlunoController alunoController;

    @Mock
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvar() {
        Aluno aluno = new Aluno();
        when(alunoService.salvar(any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoController.salvar(aluno);

        assertEquals(aluno, result);
        verify(alunoService, times(1)).salvar(any(Aluno.class));
    }

    @Test
    void testListarTodos() {
        List<Aluno> alunos = Arrays.asList(new Aluno(), new Aluno());
        when(alunoService.listarTodos()).thenReturn(alunos);

        List<Aluno> result = alunoController.listarTodos();

        assertEquals(alunos, result);
        verify(alunoService, times(1)).listarTodos();
    }

    @Test
    void testBuscarPorId() {
        Aluno aluno = new Aluno();
        when(alunoService.buscarPorId(anyLong())).thenReturn(aluno);

        Aluno result = alunoController.buscarPorId(1L);

        assertEquals(aluno, result);
        verify(alunoService, times(1)).buscarPorId(anyLong());
    }

    @Test
    void testAtualizar() {
        Aluno aluno = new Aluno();
        when(alunoService.atualizar(anyLong(), any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoController.atualizar(1L, aluno);

        assertEquals(aluno, result);
        verify(alunoService, times(1)).atualizar(anyLong(), any(Aluno.class));
    }

    @Test
    void testDeletar() {
        doNothing().when(alunoService).deletar(anyLong());

        alunoController.deletar(1L);

        verify(alunoService, times(1)).deletar(anyLong());
    }
}
