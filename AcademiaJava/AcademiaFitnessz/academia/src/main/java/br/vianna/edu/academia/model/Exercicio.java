package br.vianna.edu.academia.model;

import javax.persistence.*;

@Entity
@Table(name = "EXERCICIOS")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_exercicios")
    private int id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(nullable = false)
    private int series;

    @Column(nullable = false)
    private int repeticoes;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;

    public Exercicio() {
    }

    public Exercicio(int id, String nome, int series, int repeticoes, Treino treino) {
        this.id = id;
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.treino = treino;
    }
    public Exercicio(String nome, int series, int repeticoes, Treino treino) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.treino = treino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }
}
