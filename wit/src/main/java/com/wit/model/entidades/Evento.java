package com.wit.model.entidades;

public class Evento {
    private String tipoEvento;   // Ex.: "Publico" ou "Privado"
    private String nomeEvento;
    private String local;
    private String data;
    private String hora;
    private String descricao;
    private String foto;         // Pode ser URL ou caminho do arquivo
    private String video;        // Pode ser URL ou caminho do arquivo

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
}
