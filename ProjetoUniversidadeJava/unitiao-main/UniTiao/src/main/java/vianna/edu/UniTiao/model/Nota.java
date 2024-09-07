package vianna.edu.UniTiao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double valor;
    @ManyToOne
    @JoinColumn(name = "avaliacao_id")
    private Avaliacao avaliacao;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @OneToOne(mappedBy = "nota")
    private ComentarioProfessor comentarioProfessor;
    @Nullable
    @OneToOne(mappedBy = "nota")
    private ComentarioAluno comentarioAluno;
}
