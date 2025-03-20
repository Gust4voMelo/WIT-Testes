package com.wit;

import com.wit.model.entidades.Evento;
import com.wit.model.entidades.Usuario;
import com.wit.service.EventoService;
import com.wit.service.UsuarioService;

public class App 
{
    public static void main( String[] args )
    {
        UsuarioService usuarioService = new UsuarioService();
        EventoService eventoService = new EventoService();

        // Exemplo de cadastro de usuário (TC_008 dos testes de cadastro)
        Usuario novoUsuario = new Usuario("Miranda Robert", "miranda@email.com",
                "8178456112", "12345678", "06/02/1990", "Miranda123", "Miranda1!");
        boolean cadastroRealizado = usuarioService.cadastrarUsuario(novoUsuario);
        System.out.println("Cadastro de usuário: " + (cadastroRealizado ? "Sucesso" : "Falha"));

        // Exemplo de login (TC_001 dos testes de login)
        Usuario usuarioLogado = usuarioService.login("usuarioteste", "123456@f");
        if (usuarioLogado != null) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("Falha no login.");
        }

        // Exemplo de criação de evento (TC_00001 dos testes de criação de evento)
        Evento novoEvento = new Evento("Publico", "Evento Teste", "Local Teste", "02/01/25", "16:00", "Descrição Teste", "", "");
        boolean eventoCriado = eventoService.criarEvento(novoEvento);
        System.out.println("Criação de evento: " + (eventoCriado ? "Sucesso" : "Falha"));
    }
}
