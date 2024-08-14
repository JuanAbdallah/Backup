package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.controller.actions.ICommanderAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CallViewAction implements ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ac = (String) req.getAttribute("ac");
        ac =  (ac == null)? req.getParameter("ac") : ac;

        RequestDispatcher rd = req.getRequestDispatcher("index.jsp?pg="+ac);

        rd.forward(req, resp);
    }
}
