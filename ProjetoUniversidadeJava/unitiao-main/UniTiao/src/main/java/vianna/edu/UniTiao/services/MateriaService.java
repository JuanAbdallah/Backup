package vianna.edu.UniTiao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vianna.edu.UniTiao.model.Aluno;
import vianna.edu.UniTiao.model.Materia;
import vianna.edu.UniTiao.model.Professor;
import vianna.edu.UniTiao.model.dao.AlunoDAO;
import vianna.edu.UniTiao.model.dao.MateriaDAO;
import vianna.edu.UniTiao.model.dao.ProfessorDAO;
import vianna.edu.UniTiao.model.dto.MateriaDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriaService {
    @Autowired
    MateriaDAO materiaDAO;

    @Autowired
    ProfessorDAO professorDAO;
    @Autowired
    AlunoDAO alunoDAO;

    public List<MateriaDTO> getAllMaterias(){
        List<Materia> listaMaterias = materiaDAO.findAll();

        List<MateriaDTO> materias = new ArrayList<>();

        listaMaterias.forEach(m -> materias.add(
                new MateriaDTO(m.getId(), m.getNome(), m.getProfessor().getNome(), m.getProfessor().getLogin())
        ));
        return materias;
    }
    @Transactional
    public void saveMateria(MateriaDTO materiaInfo){
        Materia materia = new Materia();
        materia.setNome(materiaInfo.getNome());
        materia.setProfessor(professorDAO.findByLogin(materiaInfo.getLoginProfessor()));

        materiaDAO.save(materia);
    }
    @Transactional
    public void deleteMateria(int id) {
        materiaDAO.deleteById(id);
    }

    public MateriaDTO getMateriaInfo(int id) {
        Materia materia = materiaDAO.findById(id);
        MateriaDTO materiaInfo = new MateriaDTO();
        materiaInfo.setId(materia.getId());
        materiaInfo.setNome(materia.getNome());
        materiaInfo.setLoginProfessor(materia.getProfessor().getLogin());
        materiaInfo.setNomeProfessor(materia.getProfessor().getNome());

        return materiaInfo;
    }

    public void alteraMateria(MateriaDTO materiaInfo) throws Exception {
        try {
            if(professorDAO.findByLogin(materiaInfo.getLoginProfessor()) != null) {
                Materia materia = materiaDAO.findById(materiaInfo.getId());
                materia.setNome(materiaInfo.getNome());
                materia.setProfessor(professorDAO.findByLogin(materiaInfo.getLoginProfessor()));
                materiaDAO.save(materia);
            }else{
                throw new Exception("não foi possível encontrar um professor para o login informado!");
            }
        }catch (Exception e){
            throw new Exception("Não foi possível alterar: "+ e.getMessage());
        }
    }
    public List<MateriaDTO> getAllMateriasByAluno(String login){
        Aluno aluno = alunoDAO.findByLogin(login);
        List<Materia> materias = aluno.getMaterias();
        List<MateriaDTO> materiasInfo = new ArrayList<>();
        for (Materia m :
                materias) {
            MateriaDTO mDTO = new MateriaDTO();
            mDTO.setId(m.getId());
            mDTO.setNome(m.getNome());
            mDTO.setNomeProfessor(m.getProfessor().getNome());
            mDTO.setLoginProfessor(m.getProfessor().getLogin());
            materiasInfo.add(mDTO);
        }
        return materiasInfo;

    }

    public List<MateriaDTO> getAllMateriasByProfessor(String login) throws Exception{
        Professor professor = professorDAO.findByLogin(login);
        if(professor == null){
            throw new Exception("Erro ao achar professor");
        }
        List<Materia> materias = professor.getMaterias();
        if(materias == null){
            throw new Exception("Erro ao buscar materias");
        }
        List<MateriaDTO> materiasInfo = new ArrayList<>();
        for (Materia m :
                materias) {
            MateriaDTO mDTO = new MateriaDTO();
            mDTO.setId(m.getId());
            mDTO.setNome(m.getNome());
            mDTO.setNomeProfessor(m.getProfessor().getNome());
            mDTO.setLoginProfessor(m.getProfessor().getLogin());
            materiasInfo.add(mDTO);
        }
        return materiasInfo;
    }
    public void deleteAlunoFromMateria(String nomeMateria, int idAluno) throws Exception {
        Materia materia = materiaDAO.findByNome(nomeMateria);
        if (materia != null) {
            for (Aluno a :
                    materia.getAlunos()) {
                if (a.getId() == idAluno) {
                    materia.getAlunos().remove(a);
                }
            }
            materiaDAO.save(materia);
        } else {
            throw new Exception("Erro ao buscar matéria");
        }
    }
}
