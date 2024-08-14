package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vianna.edu.UniTiao.model.Aluno;
import vianna.edu.UniTiao.model.Avaliacao;
import vianna.edu.UniTiao.model.Nota;

import java.util.List;

public interface NotaDAO extends JpaRepository<Nota, Integer> {
    public List<Nota> findByAluno(Aluno aluno);
    public Nota findById(int id);
    public List<Nota> findByAvaliacao(Avaliacao avaliacao);
}
