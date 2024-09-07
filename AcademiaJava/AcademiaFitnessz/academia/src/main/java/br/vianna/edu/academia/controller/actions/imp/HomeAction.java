package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.controller.actions.ICommanderAction;
import br.vianna.edu.academia.model.Treino;
import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.AcademiaDAO;
import br.vianna.edu.academia.model.dao.imp.ExercicioDAO;
import br.vianna.edu.academia.model.dao.imp.ReservaDAO;
import br.vianna.edu.academia.model.dao.imp.TreinoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomeAction implements ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User u = (User) req.getSession().getAttribute("user");
        RequestDispatcher rd;

        if (u == null) {
            rd = req.getRequestDispatcher("index.jsp?pg=home");
        }else{
            req.setAttribute("academia",new AcademiaDAO().findById(1));
            req.setAttribute("reserva",u.getReserva());
            Treino t = new TreinoDAO().findByUsuarioId(u.getId());
            req.setAttribute("exercicios", new ExercicioDAO().findByTreino(t));
            rd = req.getRequestDispatcher("index.jsp?pg=homeLogado");
        }
        rd.forward(req, resp);
    }
}
