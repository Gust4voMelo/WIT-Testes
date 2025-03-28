package com.wit;

import com.wit.model.entidades.Evento;
import com.wit.service.EventoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class EventoServiceTest {

    @Mock
    private Evento eventoMock;

    @InjectMocks
    private EventoService eventoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarEventoComSucesso() {
        // Simulação dos valores do evento
        when(eventoMock.getNomeEvento()).thenReturn("Evento Teste");
        when(eventoMock.getLocal()).thenReturn("Local Teste");
        when(eventoMock.getDataHora()).thenReturn(LocalDateTime.of(2025, 1, 2, 16, 0)); // Agora está correto
        when(eventoMock.getDescricao()).thenReturn("Descrição Teste");

        // Executa o método a ser testado
        boolean resultado = eventoService.criarEvento(eventoMock);

        // Verifica se o evento foi criado com sucesso
        assertTrue(resultado);
        verify(eventoMock, times(1)).getNomeEvento();
        verify(eventoMock, times(1)).getLocal();
        verify(eventoMock, times(1)).getDataHora();
    }

}
