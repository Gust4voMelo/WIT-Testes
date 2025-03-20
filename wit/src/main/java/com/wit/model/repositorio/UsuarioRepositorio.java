package com.wit.model.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wit.model.entidades.Usuario;

public class UsuarioRepositorio {
    private List<Usuario> usuarios = new ArrayList<>();

    // Salva um novo usuário no repositório
    public boolean salvar(Usuario usuario) {
        // Verifica se já existe um usuário com o mesmo email ou CPF
        if (buscarPorEmail(usuario.getEmail()).isPresent() || buscarPorCPF(usuario.getCpf()).isPresent()) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    // Atualiza os dados de um usuário já existente
    public boolean atualizar(Usuario usuario) {
        Optional<Usuario> existente = buscarPorCPF(usuario.getCpf());
        if (existente.isPresent()) {
            usuarios.remove(existente.get());
            usuarios.add(usuario);
            return true;
        }
        return false;
    }

    // Busca usuário pelo email
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    // Busca usuário pelo CPF
    public Optional<Usuario> buscarPorCPF(String cpf) {
        return usuarios.stream()
                .filter(u -> u.getCpf().equals(cpf))
                .findFirst();
    }

    // Realiza o login com email ou CPF e senha
    public Optional<Usuario> login(String identificador, String senha) {
        return usuarios.stream()
                .filter(u -> (u.getEmail().equalsIgnoreCase(identificador) || u.getCpf().equals(identificador))
                        && u.getSenha().equals(senha))
                .findFirst();
    }
}

