package com.infnet.springdeploy_dr1_at.serviceTest;

import com.infnet.springdeploy_dr1_at.model.Aluno;
import com.infnet.springdeploy_dr1_at.repository.AlunoRepository;
import com.infnet.springdeploy_dr1_at.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvar() {
        Aluno aluno = new Aluno();
        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoService.salvar(aluno);

        assertEquals(aluno, result);
        verify(alunoRepository, times(1)).save(any(Aluno.class));
    }

    @Test
    void testListarTodos() {
        List<Aluno> alunos = Arrays.asList(new Aluno(), new Aluno());
        when(alunoRepository.findAll()).thenReturn(alunos);

        List<Aluno> result = alunoService.listarTodos();

        assertEquals(alunos, result);
        verify(alunoRepository, times(1)).findAll();
    }

    @Test
    void testBuscarPorId() {
        Aluno aluno = new Aluno();
        when(alunoRepository.findById(anyLong())).thenReturn(Optional.of(aluno));

        Aluno result = alunoService.buscarPorId(1L);

        assertEquals(aluno, result);
        verify(alunoRepository, times(1)).findById(anyLong());
    }

    @Test
    void testAtualizar() {
        Aluno aluno = new Aluno();
        when(alunoRepository.existsById(anyLong())).thenReturn(true);
        when(alunoRepository.save(any(Aluno.class))).thenReturn(aluno);

        Aluno result = alunoService.atualizar(1L, aluno);

        assertEquals(aluno, result);
        verify(alunoRepository, times(1)).existsById(anyLong());
        verify(alunoRepository, times(1)).save(any(Aluno.class));
    }

    @Test
    void testDeletar() {
        doNothing().when(alunoRepository).deleteById(anyLong());

        alunoService.deletar(1L);

        verify(alunoRepository, times(1)).deleteById(anyLong());
    }
}
