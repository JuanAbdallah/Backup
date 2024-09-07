package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.Piscina;
import br.vianna.edu.academia.model.dao.imp.PiscinaDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CallDeletarHorario implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        new PiscinaDAO().apagar((Piscina) new PiscinaDAO().findById(Integer.valueOf(req.getParameter("id"))));

        new HomeAction().executar(req,resp);
    }
}
