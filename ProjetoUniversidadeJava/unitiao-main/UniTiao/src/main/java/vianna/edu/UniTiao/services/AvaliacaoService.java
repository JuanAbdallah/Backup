package vianna.edu.UniTiao.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vianna.edu.UniTiao.model.*;
import vianna.edu.UniTiao.model.dao.*;
import vianna.edu.UniTiao.model.dto.AvaliacaoDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoDAO avaliacaoDAO;

    @Autowired
    MateriaDAO materiaDAO;

    @Autowired
    ComentarioProfessorDAO cpDao;
    @Autowired
    ComentarioAlunoDAO caDao;
    @Autowired
    AlunoDAO alunoDAO;
    @Autowired
    NotaDAO notaDAO;

    @Autowired UserService uService;

    public List<AvaliacaoDTO> getAll() {
        List<Avaliacao> list = avaliacaoDAO.findAll();
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();

        for (Avaliacao a:
                list) {
            AvaliacaoDTO avaliacaoInfo = new AvaliacaoDTO();
            avaliacaoInfo.setId(a.getId());
            avaliacaoInfo.setNome(a.getNome());
            avaliacaoInfo.setData(a.getData());
            avaliacaoInfo.setNomeMateria(a.getMateria().getNome());
            avaliacoes.add(avaliacaoInfo);
        }

        return avaliacoes;
    }
    public List<AvaliacaoDTO> getAllAvaliacaoMateria(String nomeMateria) {
        List<Avaliacao> list = avaliacaoDAO.findAll();
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();

        for (Avaliacao a:
                list) {
            if(a.getMateria().getNome().equals(nomeMateria)) {
                avaliacoes.add(
                        new AvaliacaoDTO(a.getId(),a.getNome(),a.getData(),a.getMateria().getNome(),0)
                );
            }
        }

        return avaliacoes;
    }
    @Transactional
    public void saveAvaliacao(AvaliacaoDTO avaliacao, String nomeMateria)throws Exception {

        if(avaliacao != null) {
            Avaliacao a = new Avaliacao();
            Materia materia = materiaDAO.findByNome(nomeMateria);

            a.setId(avaliacao.getId());
            a.setNome(avaliacao.getNome());
            a.setData(avaliacao.getData());
            a.setMateria(materia);

            avaliacaoDAO.save(a);

            List<Aluno> alunos = materia.getAlunos();
            for (Aluno aluno :
                    alunos) {
                Nota nota = new Nota();
                nota.setAvaliacao(a);
                nota.setAluno(aluno);

                ComentarioProfessor cp = new ComentarioProfessor();
                cp.setProfessor(materia.getProfessor());
                cp.setNota(nota);

                nota.setComentarioProfessor(cp);

                ComentarioAluno ca = new ComentarioAluno();
                ca.setAluno(aluno);
                ca.setNota(nota);

                nota.setComentarioAluno(ca);

                aluno.getNotas().add(nota);
                caDao.save(ca);
                cpDao.save(cp);
                alunoDAO.save(aluno);
                notaDAO.save(nota);
            }

        }else{
            throw new Exception("erro");
        }
    }

    public AvaliacaoDTO getInfos(int id) {
        Avaliacao a = avaliacaoDAO.findById(id);
        AvaliacaoDTO avaliacao = new AvaliacaoDTO();
        avaliacao.setId(a.getId());
        avaliacao.setNome(a.getNome());
        avaliacao.setNomeMateria(a.getMateria().toString());
        avaliacao.setData(a.getData());
        return avaliacao;
    }

    public void deleteAvaliacao(int id) {
        avaliacaoDAO.deleteById(id);
    }

    public void alterar(AvaliacaoDTO avaliacao) throws Exception {
        try {
            Avaliacao a = avaliacaoDAO.findById(avaliacao.getId());
            a.setData(avaliacao.getData());
            a.setNome(avaliacao.getNome());

            avaliacaoDAO.save(a);

        }catch (Exception e){
            throw new Exception("Erro ao Alterar",e);
        }
    }

    public List<AvaliacaoDTO> getAvaliacaoByAlunoAndMateria(String nomeMateria, int alunoId) {
        Materia materia = materiaDAO.findByNome(nomeMateria);
        List<Avaliacao> avaliacaoList = avaliacaoDAO.findByMateria(materia);
        List<AvaliacaoDTO> avaliacaoDTOS = new ArrayList<>();
        for (Avaliacao a :
                avaliacaoList) {
            for (Nota n :
                    a.getNotas()) {
                if(n.getAluno().getId() == alunoId){
                    avaliacaoDTOS.add(convertoToDTO(a,n));
                    break;
                }
            }
        }
        return avaliacaoDTOS;
    }
    public List<AvaliacaoDTO> getAvaliacaoByAlunoAndMateria(String nomeMateria, String login) {
        Materia materia = materiaDAO.findByNome(nomeMateria);
        List<Avaliacao> avaliacaoList = avaliacaoDAO.findByMateria(materia);
        List<AvaliacaoDTO> avaliacaoDTOS = new ArrayList<>();
        for (Avaliacao a :
                avaliacaoList) {
            for (Nota n :
                    a.getNotas()) {
                if(n.getAluno().getLogin().equals(login)){
                    avaliacaoDTOS.add(convertoToDTO(a,n));
                    break;
                }
            }
        }
        return avaliacaoDTOS;
    }

    private AvaliacaoDTO convertoToDTO(Avaliacao a, Nota n){
        AvaliacaoDTO avaliacaoInfo = new AvaliacaoDTO();
        avaliacaoInfo.setId(a.getId());
        avaliacaoInfo.setNome(a.getNome());
        avaliacaoInfo.setData(a.getData());
        avaliacaoInfo.setNomeMateria(a.getMateria().getNome());
        avaliacaoInfo.setNota(n.getValor());

        return avaliacaoInfo;
    }
    private AvaliacaoDTO convertoToDTO(Avaliacao a){
        AvaliacaoDTO avaliacaoInfo = new AvaliacaoDTO();
        avaliacaoInfo.setId(a.getId());
        avaliacaoInfo.setNome(a.getNome());
        avaliacaoInfo.setData(a.getData());
        avaliacaoInfo.setNomeMateria(a.getMateria().getNome());
        for (Nota n :
                a.getNotas()) {
            if(n.getAvaliacao().getId() == a.getId()){
                avaliacaoInfo.setNota(n.getValor());
            }
        }

        return avaliacaoInfo;
    }

    public AvaliacaoDTO getAvaliacaoById(int id) {
        Avaliacao avaliacao = avaliacaoDAO.findById(id);
        return convertoToDTO(avaliacao);

    }

    public AvaliacaoDTO getAvaliacaoByNota(int idNota) {
        Nota nota = notaDAO.findById(idNota);
        Avaliacao avaliacao = nota.getAvaliacao();
        AvaliacaoDTO avaliacaoInfo = convertoToDTO(avaliacao, nota);

        return avaliacaoInfo;
    }
}
