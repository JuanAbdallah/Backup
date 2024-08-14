package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.Piscina;
import br.vianna.edu.academia.model.ReservaPiscina;
import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.PiscinaDAO;
import br.vianna.edu.academia.model.dao.imp.ReservaDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveHoraReserva implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User u = (User) req.getSession().getAttribute("user");
        Piscina p = (Piscina) new PiscinaDAO().findById(Integer.valueOf(req.getParameter("cadReserva")));
        new PiscinaDAO().apagar(p);

        ReservaPiscina r = new ReservaPiscina();
        r.setUsuario(u);
        r.setData(p.getHorarioDisponivel());

        new ReservaDAO().inserir(r);
        new HomeAction().executar(req, resp);
    }
}
