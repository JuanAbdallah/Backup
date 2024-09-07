package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vianna.edu.UniTiao.model.Aluno;

import java.util.List;

public interface AlunoDAO extends JpaRepository<Aluno, Integer> {

    public Aluno findByLogin(String login);
    public Aluno findById(int id);
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
