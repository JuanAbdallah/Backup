package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.Exercicio;
import br.vianna.edu.academia.model.Treino;
import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.ExercicioDAO;
import br.vianna.edu.academia.model.dao.imp.TreinoDAO;
import br.vianna.edu.academia.model.dao.imp.UserDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class SaveExerciciosAction implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User usuario =  new UserDAO().findByLogin(req.getParameter("userLogin"));

    try {
        Treino treino = new Treino();

        List<Exercicio> exercicios = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            String nome = req.getParameter("nome" + i);
            int series = Integer.parseInt(req.getParameter("series" + i));
            int repeticoes = Integer.parseInt(req.getParameter("repeticoes" + i));


            Exercicio exercicio = new Exercicio(nome, series, repeticoes, treino);
            exercicios.add(exercicio);
        }



        TreinoDAO treinoDAO = new TreinoDAO();
        ExercicioDAO exercicioDAO = new ExercicioDAO();




        treino.setUsuario(usuario);

        treinoDAO.inserir(treino);


        for (Exercicio exercicio : exercicios) {
            exercicio.setTreino(treino);
            exercicioDAO.inserir(exercicio);
        }


        resp.sendRedirect("/index?pg=homeLogado");
    } catch (Exception e) {
        e.getMessage();
    }
    }
}
