package br.vianna.edu.academia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TREINAR")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_treinar")
    private int id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    @OneToMany(mappedBy = "treino")
    private List<Exercicio> listaExercicios;

    public Treino() {
    }

    public Treino(int id, User usuario, List<Exercicio> listaExercicios) {
        this.id = id;
        this.usuario = usuario;
        this.listaExercicios = listaExercicios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public List<Exercicio> getListaExercicios() {
        return listaExercicios;
    }

    public void setListaExercicios(List<Exercicio> listaExercicios) {
        this.listaExercicios = listaExercicios;
    }
}
