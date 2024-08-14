package vianna.edu.UniTiao.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaPorAlunosDTO {
    private String nomeMateria;
    private int quantidadeAlunos;
}
