package br.vianna.edu.academia.model.dao.imp;

import br.vianna.edu.academia.model.Treino;
import br.vianna.edu.academia.model.dao.GenericsDAO;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class TreinoDAO extends GenericsDAO<Treino,Integer> {
    @Override
    public void inserir(Treino obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().persist(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao Salvar o Treino :: "+e.getMessage());
        }
    }

    @Override
    public void alterar(Treino obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().merge(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao alterar o Treino :: "+e.getMessage());
        }
    }

    @Override
    public void apagar(Treino obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            Treino managedTreino = getCon().merge(obj);
            getCon().remove(managedTreino);
            getCon().getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Erro ao apagar o Treino :: " + e.getMessage());
        }
    }

    @Override
    public Object findById(Integer id) throws Exception {
        try {
            Treino t = new Treino();
            t.setId(id);
            return getCon().find(Treino.class,t);
        }catch (Exception e){
            throw new Exception("Erro ao consultar o Treino :: "+e.getMessage());
        }
    }

    @Override
    public List<Treino> findAll() throws Exception {
        TypedQuery<Treino> query = getCon().createQuery("SELECT t FROM Treino t", Treino.class);
        return query.getResultList();
    }
    public Treino findByUsuarioId(int usuarioId) throws Exception {
        try {
            TypedQuery<Treino> query = getCon().createQuery(
                    "SELECT t FROM Treino t WHERE t.usuario.id = :usuarioId", Treino.class);
            query.setParameter("usuarioId", usuarioId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new Exception("Erro ao consultar o treino do usuário :: " + e.getMessage());
        }
    }

}
