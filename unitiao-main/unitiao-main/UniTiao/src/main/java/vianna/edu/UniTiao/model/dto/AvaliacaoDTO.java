package vianna.edu.UniTiao.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoDTO {
    private int id;
    private String nome;
    private String data;
    private String nomeMateria;
    private double nota;

}
