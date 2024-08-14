package vianna.edu.UniTiao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ComentarioAluno extends Comentario{
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

}
