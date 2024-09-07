package br.vianna.edu.academia.controller;

import br.vianna.edu.academia.controller.actions.ICommanderAction;
import br.vianna.edu.academia.controller.actions.imp.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/index")
public class Controller extends HttpServlet {
    static HashMap<String, ICommanderAction> comandos = new HashMap();
    static {
        comandos.put(null, new HomeAction());
        comandos.put("index", new HomeAction());
        comandos.put("login", new CallViewAction());
        comandos.put("ajuda", new CallViewAction());
        comandos.put("verify", new VerificaLoginAction());
        comandos.put("logout", new SairAction());
        comandos.put("testaBanco", new TestaBancoAction());
        comandos.put("cadUser", new CallUserViewAction());
        comandos.put("saveUser", new CallSaveUserAction());
        comandos.put("cadExercicios", new CallViewAction());
        comandos.put("saveExercicios", new SaveExerciciosAction());
        comandos.put("altExercicios", new CallViewAction());
        comandos.put("saveAlt", new AlteraExercicios());
        comandos.put("reservaPiscina", new CallViewActionReserva());
        comandos.put("cadHora", new SaveHoraReserva());
        comandos.put("CadastraReserva", new CallViewCadastraReserva());
        comandos.put("saveCadReserva", new SaveCadReserva());
        comandos.put("qtdAluno", new SaveQtdAluno());
        comandos.put("buscar", new CallViewActionBusca());
        comandos.put("aplicaBusca", new CallViewAplicarBusca());
        comandos.put("altUser", new CallViewActionAlterar());
        comandos.put("saveAltUser", new CallAltSaveUser());
        comandos.put("delHorario", new CallDeletarHorario());
        comandos.put("delReserva", new CallDeletarReserva());
        comandos.put("contagemPessoasTreinando", new ContagemPessoasTreinandoAction());

    }
    private void resposta(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String ac = req.getParameter("ac");
            if (comandos.get(ac) == null){
                req.setAttribute("ac","Error");
                req.setAttribute("msg","Ação não encontrada!!!!");
                new CallViewAction().executar(req,resp);
            }else {
                comandos.get(ac).executar(req, resp);
            }

        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resposta(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resposta(req, resp);
    }
}
