package br.vianna.edu.academia.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reserva_piscina")
public class ReservaPiscina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_reservaPiscina")
    private int id;
    @OneToOne
    @JoinColumn(name = "reserva_id")
    private User usuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Piscina piscina;

    public ReservaPiscina(int id, User usuario, Date data, Piscina piscina) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.piscina = piscina;
    }

    public ReservaPiscina() {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Piscina getPiscina() {
        return piscina;
    }

    public void setPiscina(Piscina piscina) {
        this.piscina = piscina;
    }
}
