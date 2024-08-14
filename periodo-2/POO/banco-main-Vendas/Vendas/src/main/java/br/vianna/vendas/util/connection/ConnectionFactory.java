package br.vianna.vendas.util.connection;

import br.vianna.vendas.model.Categoria;
import br.vianna.vendas.model.Cliente;
import br.vianna.vendas.model.dao.CategoriaDAO;
import br.vianna.vendas.model.dao.ClienteDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ConnectionFactory {

    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {
        //JDBC
        //Definir o Driver (Tradutor)
       Class.forName("com.mysql.cj.jdbc.Driver");

       //Conectar no banco
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306",
                "aluno","aluno");
    }

    public static void main(String[] args) {
        ConnectionFactory cf = new ConnectionFactory();
        try {
            //System.out.println("Conectou "+cf.getConnection());

//            Cliente c = new Cliente("zezin","ze@ze",
//                    "ze2","123",
//                    LocalDate.now().minusYears(15),
//                    null);
//
//          new ClienteDAO().inserir(c);
//
//            Categoria c1 = new Categoria(0,"Alimento", false);
//            Categoria c2 = new Categoria(0,"Bebida", false);
//            CategoriaDAO cDao = new CategoriaDAO();
//            cDao.inserir(c1);
//            cDao.inserir(c2);

            Cliente c = new ClienteDAO().buscarPelaChave(1);
            System.out.println(c.getNome());

            Cliente c1 = new ClienteDAO().buscarPelaChave(50);
            if(c1==null) {
                System.out.println("usuário não encontrado!!!");
            }
            ArrayList<Cliente> cli = new ClienteDAO().buscarTodos();
            for (Cliente c2 : cli) {
                System.out.println(c2.getNome());
            }

            new ClienteDAO().apagar(4);

            c.setNome("Pedrin");
            new ClienteDAO().alterar(c);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
