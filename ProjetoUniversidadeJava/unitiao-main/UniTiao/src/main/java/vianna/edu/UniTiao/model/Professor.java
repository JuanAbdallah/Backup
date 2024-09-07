package vianna.edu.UniTiao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professor extends Usuario {

    @Getter
    @OneToMany(mappedBy = "professor")
    private List<Materia> materias;

    @OneToMany(mappedBy = "professor")
    private List<ComentarioProfessor> comentarios;

}
