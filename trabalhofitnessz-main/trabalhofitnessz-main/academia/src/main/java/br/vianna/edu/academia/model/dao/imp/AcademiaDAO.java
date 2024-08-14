package br.vianna.edu.academia.model.dao.imp;

import br.vianna.edu.academia.model.Academia;
import br.vianna.edu.academia.model.Exercicio;
import br.vianna.edu.academia.model.Treino;
import br.vianna.edu.academia.model.dao.GenericsDAO;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class AcademiaDAO extends GenericsDAO {
    @Override
    public void inserir(Object obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().persist(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao Salvar :: "+e.getMessage());
        }
    }

    @Override
    public void alterar(Object obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().merge(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao alterar :: "+e.getMessage());
        }
    }

    @Override
    public void apagar(Object obj) throws Exception {

    }

    @Override
    public Object findById(Integer id) throws Exception {
        try {
            return getCon().find(Academia.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao consultar :: " + e.getMessage());
        }
    }

    @Override
    public List findAll() throws Exception {
        return null;
    }



        public Long contarPessoasTreinandoNaAcademia() {
            Query query = getCon().createQuery("SELECT SUM(a.pessoasTreinando) FROM Academia a WHERE a.id = 1");
            return (Long) query.getSingleResult();

        }

}
