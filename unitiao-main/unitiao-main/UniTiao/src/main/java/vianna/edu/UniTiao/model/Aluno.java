package vianna.edu.UniTiao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Aluno extends Usuario {


  @ManyToMany
  @JoinTable(
          name = "aluno_materia",
          joinColumns = @JoinColumn(name = "aluno_id"),
          inverseJoinColumns = @JoinColumn(name = "materia_id")
  )
  private List<Materia> materias;
  @OneToMany(mappedBy = "aluno")
  private List<ComentarioAluno> comentarios;

  @OneToMany(mappedBy = "aluno")
  private List<Nota> notas;

  public Aluno(){
    materias = new ArrayList<>();
    comentarios = new ArrayList<>();
    notas = new ArrayList<>();
  }

  public void addMateria(Materia m){
    materias.add(m);
  }


}
