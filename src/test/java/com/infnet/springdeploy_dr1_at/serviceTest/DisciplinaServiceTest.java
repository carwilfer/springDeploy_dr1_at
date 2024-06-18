package com.infnet.springdeploy_dr1_at.serviceTest;

import com.infnet.springdeploy_dr1_at.model.Disciplina;
import com.infnet.springdeploy_dr1_at.repository.DisciplinaRepository;
import com.infnet.springdeploy_dr1_at.service.DisciplinaService;
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

public class DisciplinaServiceTest {

    @InjectMocks
    private DisciplinaService disciplinaService;

    @Mock
    private DisciplinaRepository disciplinaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvar() {
        Disciplina disciplina = new Disciplina();
        when(disciplinaRepository.save(any(Disciplina.class))).thenReturn(disciplina);

        Disciplina result = disciplinaService.salvar(disciplina);

        assertEquals(disciplina, result);
        verify(disciplinaRepository, times(1)).save(any(Disciplina.class));
    }

    @Test
    void testListarTodas() {
        List<Disciplina> disciplinas = Arrays.asList(new Disciplina(), new Disciplina());
        when(disciplinaRepository.findAll()).thenReturn(disciplinas);

        List<Disciplina> result = disciplinaService.listarTodas();

        assertEquals(disciplinas, result);
        verify(disciplinaRepository, times(1)).findAll();
    }

    @Test
    void testBuscarPorId() {
        Disciplina disciplina = new Disciplina();
        when(disciplinaRepository.findById(anyLong())).thenReturn(Optional.of(disciplina));

        Disciplina result = disciplinaService.buscarPorId(1L);

        assertEquals(disciplina, result);
        verify(disciplinaRepository, times(1)).findById(anyLong());
    }

    @Test
    void testAtualizar() {
        Disciplina disciplina = new Disciplina();
        when(disciplinaRepository.existsById(anyLong())).thenReturn(true);
        when(disciplinaRepository.save(any(Disciplina.class))).thenReturn(disciplina);

        Disciplina result = disciplinaService.atualizar(1L, disciplina);

        assertEquals(disciplina, result);
        verify(disciplinaRepository, times(1)).existsById(anyLong());
        verify(disciplinaRepository, times(1)).save(any(Disciplina.class));
    }

    @Test
    void testDeletar() {
        doNothing().when(disciplinaRepository).deleteById(anyLong());

        disciplinaService.deletar(1L);

        verify(disciplinaRepository, times(1)).deleteById(anyLong());
    }
}
