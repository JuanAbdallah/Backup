package br.vianna.edu.academia.model.dao.imp;

import br.vianna.edu.academia.model.Exercicio;
import br.vianna.edu.academia.model.Piscina;
import br.vianna.edu.academia.model.dao.GenericsDAO;

import java.util.List;

public class PiscinaDAO extends GenericsDAO<Piscina,Integer> {
    @Override
    public void inserir(Piscina obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().persist(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao Salvar a Piscina :: "+e.getMessage());
        }
    }

    @Override
    public void alterar(Piscina obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().merge(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao alterar a Piscina :: "+e.getMessage());
        }
    }

    @Override
    public void apagar(Piscina obj) throws Exception {
        try {
            if (!getCon().contains(obj)) {
                obj = getCon().merge(obj);
            }

            getCon().getTransaction().begin();
            getCon().remove(obj);
            getCon().getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Erro ao apagar a Piscina :: " + e.getMessage());
        }
    }

    @Override
    public Object findById(Integer id) throws Exception {
        try {
            return getCon().find(Piscina.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao consultar a Piscina :: " + e.getMessage());
        }
    }

    @Override
    public List<Piscina> findAll() throws Exception {
        try {
            return getCon()
                    .createQuery("select p from Piscina p order by p.id")
                    .getResultList();
        }catch (Exception e){
            throw new Exception("Erro ao consultar as reservas :: "+e.getMessage());
        }
    }
}
