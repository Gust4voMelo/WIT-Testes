package com.wit.service;

import com.wit.model.entidades.Usuario;
import java.util.regex.Pattern;

public class UsuarioService {

    // [RF001] Cadastro de Usuários
    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) return false;
        if (!isValidEmail(usuario.getEmail())) return false;
        if (!isValidCpf(usuario.getCpf())) return false;
        if (!isValidPhone(usuario.getTelefone())) return false;
        if (!isValidPassword(usuario.getPassword())) return false;

        // Persistir usuário no banco de dados (Simulação)
        System.out.println("Usuário cadastrado com sucesso: " + usuario.getUsername());
        return true;
    }

    // [RF002] Atualização de dados cadastrais
    public boolean atualizarUsuario(Usuario usuario) {
        if (usuario == null) return false;
        if (usuario.getUsername() == null || usuario.getUsername().trim().isEmpty()) return false;
        if (!isValidPassword(usuario.getPassword())) return false;

        // Atualizar no banco de dados (Simulação)
        System.out.println("Usuário atualizado: " + usuario.getUsername());
        return true;
    }

    // [RF003] Login
    public Usuario login(String identificador, String senha) {
        if (identificador == null || senha == null) return null;

        // Simulação de busca no banco de dados
        if (identificador.equals("usuario@teste.com") && senha.equals("senha123")) {
            return new Usuario("Usuário Teste", "usuario@teste.com", "11999999999", "12345678901", null, "usuarioTeste", "senha123");
        }
        
        System.out.println("Login falhou para: " + identificador);
        return null;
    }

    // Métodos de validação auxiliares
    private boolean isValidEmail(String email) {
        return email != null && Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }

    private boolean isValidCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10,11}");
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}
