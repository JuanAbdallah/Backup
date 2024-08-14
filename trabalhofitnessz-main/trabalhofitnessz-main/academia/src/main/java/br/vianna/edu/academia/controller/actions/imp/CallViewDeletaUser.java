package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.UserDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public  class CallViewDeletaUser implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User u = new UserDAO().findByLogin(req.getParameter("user"));

        new UserDAO().apagar(u);
        resp.sendRedirect("/index?pg=homeLogado");

    }
}
