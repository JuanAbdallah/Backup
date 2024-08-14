package vianna.edu.UniTiao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public abstract class Comentario {
    @Id
    @GeneratedValue
    private int Id;

    @OneToOne
    @JoinColumn(name = "nota_id")
    private Nota nota;
    private String comentario;
}
