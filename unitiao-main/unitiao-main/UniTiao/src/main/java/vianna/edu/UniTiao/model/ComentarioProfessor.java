package vianna.edu.UniTiao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComentarioProfessor extends Comentario{
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
