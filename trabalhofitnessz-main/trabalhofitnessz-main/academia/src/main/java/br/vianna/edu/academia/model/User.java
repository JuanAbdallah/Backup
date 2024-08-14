package br.vianna.edu.academia.model;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 10, nullable = false)
    private String login;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETipoUsuario tipo;

    @ManyToOne
    @JoinColumn(name = "academia_id")
    private Academia academia;

    @OneToOne(mappedBy = "usuario")
    private Treino treino;


    @OneToOne(mappedBy = "usuario")
    private ReservaPiscina reserva;

    public User() {
        nome = "";
        login = "";
        email = "";
    }

    public User(int id, String nome, String login, String email, String senha, ETipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public User(int id, String nome, String login, String email, String senha, ETipoUsuario tipo, Academia academia, Treino treino, ReservaPiscina reserva) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.academia = academia;
        this.treino = treino;
        this.reserva = reserva;

    }
    public boolean isAdmin(){
        return tipo == ETipoUsuario.ADMIN;
    }
    public boolean isUser(){
        return tipo == ETipoUsuario.USER;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ETipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(ETipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public ReservaPiscina getReserva() {
        return reserva;
    }

    public void setReserva(ReservaPiscina reserva) {
        this.reserva = reserva;
    }

    public Treino getTreinar() {
        return treino;
    }

    public void setTreinar(Treino treino) {
        this.treino = treino;
    }
}
