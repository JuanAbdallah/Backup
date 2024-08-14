package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vianna.edu.UniTiao.model.Materia;

public interface MateriaDAO extends JpaRepository<Materia, Integer> {
    public Materia findById(int id);

    public Materia findByNome(String nomeMateria);
}
