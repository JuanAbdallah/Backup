package vianna.edu.UniTiao.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
    private int id;
    private String nome, nomeProfessor, loginProfessor;
}
