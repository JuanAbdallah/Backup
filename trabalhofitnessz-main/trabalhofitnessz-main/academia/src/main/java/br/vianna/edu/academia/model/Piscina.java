package br.vianna.edu.academia.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Piscina")
public class Piscina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piscina")
    private int id;

    @OneToMany(mappedBy = "piscina")
    private List<ReservaPiscina> listaReserva;
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioDisponivel;

    public Piscina() {
    }

    public Piscina(int id, List<ReservaPiscina> listaReserva, Date horarioDisponivel) {
        this.id = id;
        this.listaReserva = listaReserva;
        this.horarioDisponivel = horarioDisponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ReservaPiscina> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<ReservaPiscina> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public Date getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(Date horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }
}