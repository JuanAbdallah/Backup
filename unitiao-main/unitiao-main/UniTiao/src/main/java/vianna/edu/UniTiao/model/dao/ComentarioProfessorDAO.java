package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vianna.edu.UniTiao.model.Comentario;
import vianna.edu.UniTiao.model.ComentarioProfessor;

public interface ComentarioProfessorDAO extends JpaRepository<Comentario, Integer> {
    public ComentarioProfessor findById(int id);
}
