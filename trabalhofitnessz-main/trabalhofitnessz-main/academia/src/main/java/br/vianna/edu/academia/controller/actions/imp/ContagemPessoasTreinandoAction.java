package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.dao.imp.AcademiaDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContagemPessoasTreinandoAction implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       Long pessoasT =  new AcademiaDAO().contarPessoasTreinandoNaAcademia();
        ObjectMapper mapper = new ObjectMapper();
        String jsonPessoas = mapper.writeValueAsString(pessoasT);
        resp.getWriter().write(jsonPessoas);

    }
}
