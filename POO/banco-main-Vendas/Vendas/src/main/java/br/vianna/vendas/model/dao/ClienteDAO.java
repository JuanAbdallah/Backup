package br.vianna.vendas.model.dao;

import br.vianna.vendas.model.Cliente;
import br.vianna.vendas.model.faces.IGenericsDAO;
import br.vianna.vendas.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        //1º Conectar no Banco
        Connection c = ConnectionFactory.getConnection();
        //2º Montar Consulta SQL
        String sql = "UPDATE vendas.usuario " +
                "SET nome=?, email=?, login=?, " +
                " data_nascimento=? " +
                "WHERE id=?; ";
        //3º Trocar parametos
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, cli.getNome());
        ps.setString(2, cli.getEmail());
        ps.setString(3, cli.getLogin());
        //ps.setString(4, cli.getSenha());
        ps.setString(4,
                cli.getDataNascimento()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        ps.setInt(5, cli.getId());
        //4º Executar
        ps.execute();
    }

    @Override
    public void apagar(int key) throws SQLException, ClassNotFoundException {
        //1º Conectar no Banco
        Connection c = ConnectionFactory.getConnection();
        //2º Montar Consulta SQL
        String sql = "DELETE FROM vendas.usuario " +
                " WHERE id=?; ";
        //3º Trocar parametos
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, key);
        //4º Executar
        ps.execute();
    }

    @Override
    public Cliente buscarPelaChave(int key) throws SQLException, ClassNotFoundException {
        //1º Conectar no Banco
        Connection c = ConnectionFactory.getConnection();
        //2º Montar Consulta SQL
        String sql = "SELECT id, nome, email, login, senha, " +
                "data_nascimento, perfil " +
                "FROM vendas.usuario " +
                "WHERE id=? and perfil='CLIENTE'; ";
        //3º Trocar parametos
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, key);
        //4º Executar
        ResultSet rs = ps.executeQuery();
        //5º Passo, converer linhas x colunas em Objetos
        Cliente cli = null;
        if (rs.next()){
           cli = new Cliente( rs.getString(2),
                   rs.getString("email"),
                   rs.getString("login"),
                   rs.getString("senha"),
                   LocalDate.parse(
                           rs.getString("data_nascimento")
                                   .substring(0,10),
                           DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                   null
                   );
           cli.setId( rs.getInt("id") );
        }else{
           cli = null;
        }
        return cli;
    }

    @Override
    public ArrayList<Cliente> buscarTodos() throws SQLException, ClassNotFoundException {
        //1º Conectar no Banco
        Connection c = ConnectionFactory.getConnection();
        //2º Montar Consulta SQL
        String sql = "SELECT id, nome, email, login, senha, " +
                "data_nascimento, perfil " +
                "FROM vendas.usuario " +
                "WHERE perfil='CLIENTE'; ";
        //3º Trocar parametos
        PreparedStatement ps = c.prepareStatement(sql);
        //4º Executar
        ResultSet rs = ps.executeQuery();
        //5º Passo, converer linhas x colunas em Objetos
        ArrayList<Cliente> clientes = new ArrayList<>();
        while (rs.next()){
            Cliente cli = new Cliente( rs.getString(2),
                    rs.getString("email"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    LocalDate.parse(
                            rs.getString("data_nascimento")
                                    .substring(0,10),
                            DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    null
            );
            cli.setId( rs.getInt("id") );

            clientes.add(cli);
        }
        return clientes;
    }

    public ArrayList<Cliente> buscarPeloNome() throws SQLException, ClassNotFoundException{
        return null;
    }

    public Cliente buscarPeloLoginAndSenha(String login,
                                           String senha)
            throws SQLException, ClassNotFoundException{
        return null;
    }

}
