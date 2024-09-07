package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.Academia;
import br.vianna.edu.academia.model.dao.imp.AcademiaDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveQtdAluno implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Academia a = (Academia) new AcademiaDAO().findById(1);
        int pessoas = Integer.parseInt(req.getParameter("pessoas"));
        a.setPessoasTreinando(pessoas);

            new AcademiaDAO().alterar(a);

        resp.sendRedirect("/index?pg=homeLogado");
    }
}
