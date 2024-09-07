package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vianna.edu.UniTiao.model.Avaliacao;
import vianna.edu.UniTiao.model.Materia;

import java.util.List;

public interface AvaliacaoDAO extends JpaRepository<Avaliacao, Integer> {
    public Avaliacao findById(int id);

    public List<Avaliacao> findByMateria(Materia materia);
}
