package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.Piscina;
import br.vianna.edu.academia.model.ReservaPiscina;
import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.ReservaDAO;
import br.vianna.edu.academia.model.dao.imp.UserDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CallDeletarReserva implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User u = new UserDAO().findByLogin(req.getParameter("nome"));
        ReservaPiscina p = u.getReserva();
        new ReservaDAO().apagar(p);
        new HomeAction().executar(req,resp);
    }
}
