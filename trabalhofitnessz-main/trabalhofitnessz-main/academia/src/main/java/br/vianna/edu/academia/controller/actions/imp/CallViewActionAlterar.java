package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CallViewActionAlterar implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("usuario",req.getSession().getAttribute("user"));
        new CallViewAction().executar(req, resp);
    }
}
