package com.wit.service;

import com.wit.model.entidades.Evento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EventoService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // [RF005] Criação de Evento
    public boolean criarEvento(Evento evento) {
        if (evento == null) return false;
        if (evento.getNomeEvento() == null || evento.getNomeEvento().trim().isEmpty()) return false;
        if (evento.getLocal() == null || evento.getLocal().trim().isEmpty()) return false;
        
        LocalDateTime dataEvento = parseData(evento.getData());
        if (dataEvento == null || dataEvento.isBefore(LocalDateTime.now())) return false;

        // Persistir evento no banco de dados (Simulação)
        System.out.println("Evento criado com sucesso: " + evento.getNomeEvento());
        return true;
    }
    
    // Método para atualizar evento
    public boolean atualizarEvento(Evento evento) {
        if (evento == null || evento.getNomeEvento() == null || evento.getNomeEvento().trim().isEmpty()) return false;
        
        LocalDateTime dataEvento = parseData(evento.getData());
        if (dataEvento != null && dataEvento.isBefore(LocalDateTime.now())) return false;

        // Atualizar evento no banco de dados (Simulação)
        System.out.println("Evento atualizado: " + evento.getNomeEvento());
        return true;
    }

    // Método para converter String para LocalDateTime
    private LocalDateTime parseData(String data) {
        if (data == null || data.trim().isEmpty()) return null;
        try {
            return LocalDateTime.parse(data, FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao converter data: " + data);
            return null;
        }
    }
}
