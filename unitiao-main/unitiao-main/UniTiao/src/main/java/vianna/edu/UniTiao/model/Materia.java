package vianna.edu.UniTiao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    @ManyToMany(mappedBy = "materias")
    private List<Aluno> alunos;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @OneToMany(mappedBy = "materia")
    private List<Avaliacao> avaliacoes;

    public Materia(){
        alunos = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }

}
