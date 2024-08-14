package vianna.edu.UniTiao.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vianna.edu.UniTiao.model.Comentario;
import vianna.edu.UniTiao.model.ComentarioAluno;
import vianna.edu.UniTiao.model.ComentarioProfessor;
import vianna.edu.UniTiao.model.Nota;
import vianna.edu.UniTiao.model.dao.*;
import vianna.edu.UniTiao.model.dto.ComentarioDTO;
import vianna.edu.UniTiao.model.dto.NotaDTO;

@Service
public class ComentarioService {
    @Autowired
    ComentarioAlunoDAO caDAO;
    @Autowired
    ComentarioProfessorDAO cpDAO;
    @Autowired
    MateriaDAO materiaDAO;
    @Autowired
    AvaliacaoDAO avaliacaoDAO;
    @Autowired
    NotaDAO notaDAO;
    @Autowired
    AlunoDAO alunoDAO;
    @Autowired
    ComentarioDAO cDAO;

    public ComentarioDTO getComentarioProfessor(int idNota) throws Exception {
        Nota nota = notaDAO.findById(idNota);
        ComentarioProfessor cp = nota.getComentarioProfessor();
        ComentarioDTO comentarioInfo = new ComentarioDTO();
        if (nota == null) {
            throw new Exception("Erro ao procurar comentário!");
        }
        comentarioInfo.setId(cp.getId());
        comentarioInfo.setComentario(cp.getComentario());
        return comentarioInfo;
    }

    public ComentarioDTO getComentarioAluno(int idNota) throws Exception {
        Nota nota = notaDAO.findById(idNota);
        ComentarioAluno ca = nota.getComentarioAluno();
        ComentarioDTO comentarioInfo = new ComentarioDTO();
        if (nota == null) {
            throw new Exception("Erro ao procurar comentário!");
        }
        comentarioInfo.setId(ca.getId());
        comentarioInfo.setComentario(ca.getComentario());
        return comentarioInfo;
    }

    @Transactional
    public void saveComentarioProfessor(int idComentario, ComentarioDTO comentarioInfo) throws Exception {
        ComentarioProfessor cp = cpDAO.findById(idComentario);
        if (cp != null) {
            cp.setComentario(comentarioInfo.getComentario());
            System.out.println(cp);
            cpDAO.save(cp);
        } else {
            throw new Exception("Erro ao salvr comentario");
        }
    }

    public void saveComentarioAluno(int idComentario, ComentarioDTO comentarioInfo) throws Exception {
        ComentarioAluno ca = caDAO.findById(idComentario);
        if (ca != null) {
            ca.setComentario(comentarioInfo.getComentario());
            System.out.println(ca);
            caDAO.save(ca);
        } else {
            throw new Exception("Erro ao salvr comentario");
        }
    }

    public NotaDTO getNotaByComentario(int idComentario) throws Exception {
        Comentario cp = cDAO.findById(idComentario);
        if (cp != null) {
            Nota nota = cp.getNota();
            NotaDTO notaInfo = new NotaDTO();
            notaInfo.setId(nota.getId());
            notaInfo.setNota(nota.getValor());

            return notaInfo;
        }else{
                throw new Exception("Erro ao buscar nota");
            }
        }
    }
