package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.dao.imp.PiscinaDAO;
import br.vianna.edu.academia.model.dao.imp.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CallViewActionBusca implements br.vianna.edu.academia.controller.actions.ICommanderAction {

    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.setAttribute("alunos", new UserDAO().findAll());
        new CallViewAction().executar(req, resp);
    }
}
