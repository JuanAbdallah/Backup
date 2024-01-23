package br.vianna.vendas.model.dao;

import br.vianna.vendas.model.Categoria;
import br.vianna.vendas.model.Cliente;
import br.vianna.vendas.model.faces.IGenericsDAO;
import br.vianna.vendas.util.connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CategoriaDAO implements IGenericsDAO<Categoria> {

    public void inserir(Categoria cate) throws SQLException, ClassNotFoundException {
        //1º Conectar no Banco
        Connection c = ConnectionFactory.getConnection();
        //2º Montar Consulta SQL
        String sql = "INSERT INTO vendas.categoria " +
                "(nome, tem_isencao) " +
                "VALUES(?, ?); ";
        //3º Trocar parametos
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, cate.getNome());
        ps.setBoolean(2, cate.isTemIsencao());

        //4º Executar
        ps.execute();
    }

    @Override
    public void alterar(Categoria cli) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void apagar(int key) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Categoria buscarPelaChave(int cli) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Categoria> buscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }


}
