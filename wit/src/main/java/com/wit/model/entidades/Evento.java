package com.wit.model.entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Evento {
    private String tipoEvento;
    private String nomeEvento;
    private String local;
    private String data; // Exemplo: "02/01/2025"
    private String hora; // Exemplo: "16:00"
    private String descricao;
    private String foto;
    private String video;

    // Construtor padrão
    public Evento() {}

    // Construtor com parâmetros
    public Evento(String tipoEvento, String nomeEvento, String local, String data, String hora, String descricao, String foto, String video) {
        this.tipoEvento = tipoEvento;
        this.nomeEvento = nomeEvento;
        this.local = local;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.foto = foto;
        this.video = video;
    }

    // Getters e Setters
    public String getTipoEvento() {
        return tipoEvento;
    }
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public String getNomeEvento() {
        return nomeEvento;
    }
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getVideo() {
        return video;
    }
    public void setVideo(String video) {
        this.video = video;
    }

    // Novo método para converter data/hora em LocalDateTime
    public LocalDateTime getDataHora() {
        if (data == null || hora == null) return null;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            return LocalDateTime.parse(data + " " + hora, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Erro ao converter data/hora: " + data + " " + hora);
            return null;
        }
    }
}
