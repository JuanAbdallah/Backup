package br.vianna.edu.academia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ACADEMIA")
public class Academia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_academia")
    private int id;

    @OneToMany(mappedBy = "academia")
    private List<User> listaUsuarios;

    private int pessoasTreinando;

    public Academia() {
    }

    public Academia(int id, List<User> listaUsuarios, int pessoasTreinando) {
        this.id = id;
        this.listaUsuarios = listaUsuarios;
        this.pessoasTreinando = pessoasTreinando;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<User> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getPessoasTreinando() {
        return pessoasTreinando;
    }

    public void setPessoasTreinando(int pessoasTreinando) {
        this.pessoasTreinando = pessoasTreinando;
    }
}
