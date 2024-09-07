package br.vianna.edu.academia;

import br.vianna.edu.academia.model.ETipoUsuario;
import br.vianna.edu.academia.model.Exercicio;
import br.vianna.edu.academia.model.Treino;
import br.vianna.edu.academia.model.User;
import br.vianna.edu.academia.model.dao.imp.ExercicioDAO;
import br.vianna.edu.academia.model.dao.imp.ReservaDAO;
import br.vianna.edu.academia.model.dao.imp.TreinoDAO;
import br.vianna.edu.academia.model.dao.imp.UserDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        User u = new UserDAO().findByLogin("tiao");
        System.out.println(new ReservaDAO().findByUsuario(u).getData());
    }
    }



