package br.vianna.edu.academia.controller.actions.imp;



import br.vianna.edu.academia.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class CallUserViewAction implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("user", new User());
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp?pg=cadUser");

        rd.forward(req, resp);

    }
}
