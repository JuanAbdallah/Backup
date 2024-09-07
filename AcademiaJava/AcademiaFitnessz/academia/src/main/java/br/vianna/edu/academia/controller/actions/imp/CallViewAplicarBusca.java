package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.Treino;
import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.ExercicioDAO;
import br.vianna.edu.academia.model.dao.imp.TreinoDAO;
import br.vianna.edu.academia.model.dao.imp.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CallViewAplicarBusca implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       User u = new UserDAO().findByLogin(req.getParameter("nome"));
       req.setAttribute("user", u);
        Treino t = new TreinoDAO().findByUsuarioId(u.getId());
        req.setAttribute("exercicios", new ExercicioDAO().findByTreino(t));





        new CallViewAction().executar(req, resp);
    }
}
