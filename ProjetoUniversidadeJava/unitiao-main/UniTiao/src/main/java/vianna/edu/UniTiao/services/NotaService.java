package vianna.edu.UniTiao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vianna.edu.UniTiao.model.Aluno;
import vianna.edu.UniTiao.model.Avaliacao;
import vianna.edu.UniTiao.model.Nota;
import vianna.edu.UniTiao.model.dao.AlunoDAO;
import vianna.edu.UniTiao.model.dao.AvaliacaoDAO;
import vianna.edu.UniTiao.model.dao.NotaDAO;
import vianna.edu.UniTiao.model.dto.NotaDTO;

import java.util.List;

@Service
public class NotaService {
    @Autowired
    NotaDAO notaDAO;
    @Autowired
    AvaliacaoDAO avaliacaoDAO;
    @Autowired
    AlunoDAO alunoDAO;
    public NotaDTO getNotaAvaliacao(int idAvaliacao, int idAluno) throws Exception {
        Avaliacao avaliacao = avaliacaoDAO.findById(idAvaliacao);
        List<Nota> notas = notaDAO.findByAvaliacao(avaliacao);
        Nota nota = new Nota();
        for (Nota n :
                notas) {
            if (n.getAluno().getId() == idAluno) {
                nota = n;
                break;
            }
            }
        NotaDTO notaDTO = new NotaDTO(nota.getId(), nota.getValor());
        return notaDTO;
    }

    public NotaDTO getNotaByAluno(int id){
        Aluno aluno = alunoDAO.findById(id);
        List<Nota> notas = notaDAO.findByAluno(aluno);

        return null;
    }

    public void saveNota(NotaDTO notaInfo, int idAvaliacao, int idAluno) throws Exception {
        Avaliacao avaliacao = avaliacaoDAO.findById(idAvaliacao);
        List<Nota> notas = notaDAO.findByAvaliacao(avaliacao);
        Nota nota = new Nota();
        for (Nota n :
                notas) {
            if(n.getAluno().getId() == idAluno){
                nota = n;
            }
        }
        if(nota != null){
            nota.setValor(notaInfo.getNota());
            notaDAO.save(nota);
        }else{
            throw new Exception("Não foi possível salvar");
        }
    }

    public int getAlunoId(int idNota) {
        Nota nota = notaDAO.findById(idNota);
        return nota.getAluno().getId();
    }
}
