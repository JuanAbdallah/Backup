package br.vianna.edu.academia.model.dao.imp;

import br.vianna.edu.academia.model.Exercicio;
import br.vianna.edu.academia.model.ReservaPiscina;
import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.GenericsDAO;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReservaDAO extends GenericsDAO<ReservaPiscina, Integer> {
    @Override
    public void inserir(ReservaPiscina obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().persist(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao Salvar a Reserva :: "+e.getMessage());
        }
    }

    @Override
    public void alterar(ReservaPiscina obj) throws Exception {
        try {
            getCon().getTransaction().begin();
            getCon().merge(obj);
            getCon().getTransaction().commit();
        }catch (Exception e){
            throw new Exception("Erro ao alterar a Reserva :: "+e.getMessage());
        }
    }

    @Override
    public void apagar(ReservaPiscina obj) throws Exception {
        try {
            if (!getCon().contains(obj)) {
                obj = getCon().merge(obj);
            }

            getCon().getTransaction().begin();
            getCon().remove(obj);
            getCon().getTransaction().commit();
        } catch (Exception e) {
            throw new Exception("Erro ao apagar a Reserva :: " + e.getMessage());
        }
    }

    @Override
    public Object findById(Integer id) throws Exception {
        try {
            return getCon().find(ReservaPiscina.class, id);
        } catch (Exception e) {
            throw new Exception("Erro ao consultar a Reserva :: " + e.getMessage());
        }
    }

    @Override
    public List<ReservaPiscina> findAll() throws Exception {
        try {
            return getCon()
                    .createQuery("select r from ReservaPiscina r order by r.id")
                    .getResultList();
        }catch (Exception e){
            throw new Exception("Erro ao consultar as reservas :: "+e.getMessage());
        }
    }

    public ReservaPiscina findByUsuario(User u) throws NoResultException {
        TypedQuery<ReservaPiscina> query = getCon().createQuery(
                "SELECT rp FROM ReservaPiscina rp WHERE rp.usuario = :usuario", ReservaPiscina.class);
        query.setParameter("usuario", u);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new NoResultException("No reservation found for this user.");
        }
    }
    }

