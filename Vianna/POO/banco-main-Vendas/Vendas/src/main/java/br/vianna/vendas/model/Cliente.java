package br.vianna.vendas.model;

import br.vianna.vendas.model.e.ETipoUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente extends Usuario {

    public Cliente() {
        perfil = ETipoUsuario.CLIENTE;
    }

    public Cliente(String nome, String email, String login,
                   String senha, LocalDate dataNascimento,
                   LocalDateTime dataUltimoAcesso) {
        super(nome, email, login, senha,
                dataNascimento, dataUltimoAcesso,
                ETipoUsuario.CLIENTE);
    }
}
