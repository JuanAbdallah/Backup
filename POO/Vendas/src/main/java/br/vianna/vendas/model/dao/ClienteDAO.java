package br.vianna.vendas.model.dao;

import br.vianna.vendas.model.Cliente;
import br.vianna.vendas.model.faces.IGenericsDAO;
import br.vianna.vendas.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClienteDAO implements IGenericsDAO<Cliente> {

    public void inserir(Cliente cli) throws SQLException, ClassNotFoundException {
        //1º Conectar no Banco
        Connection c = ConnectionFactory.getConnection();
        //2º Montar Consulta SQL
        String sql = "INSERT INTO vendas.usuario " +
                "(nome, email, login, senha, data_nascimento, perfil) " +
                "VALUES(?, ?, ?, md5(?), ?, 'CLIENTE');";
        //3º Trocar parametos
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, cli.getNome());
        ps.setString(2, cli.getEmail());
        ps.setString(3, cli.getLogin());
        ps.setString(4, cli.getSenha());
        ps.setString(5,
                cli.getDataNascimento()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        //4º Executar
        ps.execute();

    }

    @Override
    public void alterar(Cliente cli) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void apagar(int key) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Cliente buscarPelaChave(int cli) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Cliente> buscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }


}
