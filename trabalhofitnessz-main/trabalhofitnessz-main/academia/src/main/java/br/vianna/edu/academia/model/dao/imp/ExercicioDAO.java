package br.vianna.edu.academia.model.dao.imp;

import br.vianna.edu.academia.model.Exercicio;
import br.vianna.edu.academia.model.Treino;
import br.vianna.edu.academia.model.dao.GenericsDAO;

import javax.persistence.TypedQuery;
import java.util.List;

public class ExercicioDAO extends GenericsDAO<Exercicio,Integer> {

    @Override
    public void inserir(Exercicio obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().persist(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao Salvar o Exercício :: "+e.getMessage());
        }
    }

    @Override
    public void alterar(Exercicio obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().merge(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao alterar o Exercício :: "+e.getMessage());
        }
    }

    @Override
    public void apagar(Exercicio obj) throws Exception {
        try {
            if (!getCon().contains(obj)) {
                obj = getCon().merge(obj);
            }

            getCon().getTransaction().begin();
            getCon().remove(obj);
            getCon().getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Erro ao apagar o Exercício :: " + e.getMessage());
        }
    }


    @Override
    public Object findById(Integer id) throws Exception {
        try {
            return getCon().find(Exercicio.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao consultar o Exercício :: " + e.getMessage());
        }
    }


    @Override
    public List<Exercicio> findAll() throws Exception {
        try {
            return getCon()
                    .createQuery("select e from Exercicio e order by e.id")
                    .getResultList();
        }catch (Exception e){
            throw new Exception("Erro ao consultar os exercicios :: "+e.getMessage());
        }
    }
    public List<Exercicio> findByTreino(Treino treino) throws Exception {
        try {
            TypedQuery<Exercicio> query = getCon().createQuery(
                    "SELECT e FROM Exercicio e WHERE e.treino = :treino", Exercicio.class);
            query.setParameter("treino", treino);
            return query.getResultList();
        } catch (Exception e) {
            throw new Exception("Erro ao consultar os exercícios do treino :: " + e.getMessage());
        }
    }

}
