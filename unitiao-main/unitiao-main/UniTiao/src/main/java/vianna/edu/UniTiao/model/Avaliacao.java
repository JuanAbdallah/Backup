package vianna.edu.UniTiao.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String nome;
    @OneToMany(mappedBy = "avaliacao")
    private List<Nota> notas;

    private String data;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;


}
