package vianna.edu.UniTiao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;




@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String email;
    private String senha;

    @Column(unique = true, length = 20, nullable = false)
    private String login;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimoAcesso;
}