package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vianna.edu.UniTiao.model.Professor;

import java.util.List;

public interface ProfessorDAO extends JpaRepository<Professor, Integer> {

    public Professor findByLogin(String login);
    public Professor findById(int id);


    List<Professor> findByNomeContainingIgnoreCase(String nome);
}
