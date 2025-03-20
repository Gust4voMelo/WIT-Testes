package com.wit.model.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wit.model.entidades.Evento;

public class EventoRepositorio {
    private List<Evento> eventos = new ArrayList<>();

    // Salva um novo evento
    public boolean salvar(Evento evento) {
        // Aqui você pode incluir validações específicas, se necessário
        eventos.add(evento);
        return true;
    }

    // Atualiza um evento já cadastrado
    public boolean atualizar(Evento evento) {
        Optional<Evento> existente = buscarPorNome(evento.getNomeEvento());
        if (existente.isPresent()) {
            eventos.remove(existente.get());
            eventos.add(evento);
            return true;
        }
        return false;
    }

    // Busca um evento pelo nome (pode ser adaptado para usar ID ou outra propriedade)
    public Optional<Evento> buscarPorNome(String nomeEvento) {
        return eventos.stream()
                .filter(e -> e.getNomeEvento().equalsIgnoreCase(nomeEvento))
                .findFirst();
    }
}