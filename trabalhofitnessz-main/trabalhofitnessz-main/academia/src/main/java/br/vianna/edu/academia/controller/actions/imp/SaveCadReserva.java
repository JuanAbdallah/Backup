package br.vianna.edu.academia.controller.actions.imp;

import br.vianna.edu.academia.model.Piscina;
import br.vianna.edu.academia.model.dao.imp.PiscinaDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveCadReserva implements br.vianna.edu.academia.controller.actions.ICommanderAction {
    @Override
    public boolean ehPublico() {
        return true;
    }

    @Override
    public void executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Piscina p = new Piscina();


        String horarioString = req.getParameter("ano") + "-" + req.getParameter("mes") + "-" +
                req.getParameter("dia") + " " + req.getParameter("hora") + ":" +
                req.getParameter("minutos") + ":00";


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date horario = formatter.parse(horarioString);
            p.setHorarioDisponivel(horario);
            new PiscinaDAO().inserir(p);

        } catch (ParseException e) {
            throw new RuntimeException("Erro ao converter data: " + e.getMessage());
        }
        resp.sendRedirect("/index?pg=homeLogado");
    }
}
