package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vianna.edu.UniTiao.model.Aluno;
import vianna.edu.UniTiao.model.Comentario;
import vianna.edu.UniTiao.model.ComentarioAluno;

public interface ComentarioAlunoDAO extends JpaRepository<Comentario, Integer> {
    public ComentarioAluno findById(int id);
}
