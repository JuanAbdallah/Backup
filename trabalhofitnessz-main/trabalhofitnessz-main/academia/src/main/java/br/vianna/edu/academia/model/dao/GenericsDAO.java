package br.vianna.edu.academia.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class GenericsDAO<C, K> {
    private EntityManager con;
    public GenericsDAO(){
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("poo");

        con= emf.createEntityManager();
    }

    public EntityManager getCon(){
        return con;
    }
    public abstract void inserir(C obj) throws Exception;
    public abstract void alterar(C obj) throws Exception;
    public abstract void apagar(C obj) throws Exception;

    public abstract Object findById(Integer id) throws Exception;

    public abstract List<C> findAll() throws Exception;
}
