package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.UserDAO;
import br.vianna.edu.academia.util.UtilService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class VerificaLoginAction implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User u = new UserDAO().findByLoginAndSenha(req.getParameter("cpLogin"),
                    UtilService.md5(req.getParameter("cpSenha")) );
            if (u == null){
                req.setAttribute("msg", "Login ou Senha Incorreta");
                req.setAttribute("ac", "login");
                new CallViewAction().executar(req, resp);
            }else{
                req.getSession().setAttribute("user", u);
                new HomeAction().executar(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("msg", e.getMessage());
            new CallErrorPageAction().executar(req, resp);
        }


    }
}
