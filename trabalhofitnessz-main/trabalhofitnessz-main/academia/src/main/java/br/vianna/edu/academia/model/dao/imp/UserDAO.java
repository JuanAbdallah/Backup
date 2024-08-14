package br.vianna.edu.academia.model.dao.imp;

import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.GenericsDAO;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import java.util.List;

public class UserDAO extends GenericsDAO<User,Integer> {
    @Override
    public void inserir(User obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().persist(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao Salvar o usuário :: "+e.getMessage());
        }
    }

    @Override
    public void alterar(User obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().merge(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao alterar o usuário :: "+e.getMessage());
        }
    }

    @Override
    public void apagar(User obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().merge(obj);
            getCon().remove(obj);
            getCon().getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Erro ao apagar o usuário :: " + e.getMessage());
        }
    }

    @Override
    public Object findById(Integer id) throws Exception {
        try {
            User u = new User();
            u.setId(id);
            return getCon().find(User.class,u);
        }catch (Exception e){
            throw new Exception("Erro ao consultar o usuário :: "+e.getMessage());
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        try {
            return getCon().createQuery("select u from User u").getResultList();
        }catch (Exception e){
            throw new Exception("Erro ao consultar o usuário :: "+e.getMessage());
        }
    }
    public User findByLoginAndSenha(String login, String senha) throws Exception {
        try {
            //JPQL
            Query query =  getCon().createQuery("select u from User u where " +
                    "u.login = :log and u.senha = :sen");

            query.setParameter("log", login);
            query.setParameter("sen", senha);

            return (User) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch (NonUniqueResultException e){
            throw new Exception("Mais de um usuário encontrado ");
        }catch (Exception e){
            throw new Exception("Erro ao consultar o usuário :: "+e.getMessage());
        }
    }
    public User findByLogin(String login) throws Exception {
        try {
            //JPQL
            Query query =  getCon().createQuery("select u from User u where " +
                    "u.login = :log ");

            query.setParameter("log", login);


            return (User) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }catch (NonUniqueResultException e){
            throw new Exception("Mais de um usuário encontrado ");
        }catch (Exception e){
            throw new Exception("Erro ao consultar o usuário :: "+e.getMessage());
        }
    }
}

