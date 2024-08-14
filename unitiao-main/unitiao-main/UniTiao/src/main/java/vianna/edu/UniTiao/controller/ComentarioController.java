package vianna.edu.UniTiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vianna.edu.UniTiao.model.dto.AvaliacaoDTO;
import vianna.edu.UniTiao.model.dto.ComentarioDTO;
import vianna.edu.UniTiao.model.dto.NotaDTO;
import vianna.edu.UniTiao.services.AvaliacaoService;
import vianna.edu.UniTiao.services.ComentarioService;
import vianna.edu.UniTiao.services.NotaService;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    ComentarioService cService;
    @Autowired
    AvaliacaoService aService;
    @Autowired
    NotaService nService;
    @PostMapping("/professor/{idComentario}")
    private String saveComentarioProfessor(Model model, ComentarioDTO comentarioInfo, @PathVariable int idComentario) throws Exception {
        cService.saveComentarioProfessor(idComentario, comentarioInfo);
        NotaDTO notaInfo =  cService.getNotaByComentario(idComentario);
        AvaliacaoDTO avaliacaoInfo = aService.getAvaliacaoByNota(notaInfo.getId());
        model.addAttribute("nota",notaInfo);
        model.addAttribute("avaliacao", avaliacaoInfo);
        model.addAttribute("idAluno", nService.getAlunoId(notaInfo.getId()));
        model.addAttribute("comentarioP", cService.getComentarioProfessor(notaInfo.getId()));
        model.addAttribute("comentarioA", cService.getComentarioAluno(notaInfo.getId()));
        model.addAttribute("comentario", new ComentarioDTO());

        return "avaliacao/menuNota";
    }
    @PostMapping("/aluno/{idComentario}")
    private String saveComentarioAluno(Model model, ComentarioDTO comentarioInfo, @PathVariable int idComentario) throws Exception {
        cService.saveComentarioAluno(idComentario, comentarioInfo);
        NotaDTO notaInfo =  cService.getNotaByComentario(idComentario);
        AvaliacaoDTO avaliacaoInfo = aService.getAvaliacaoByNota(notaInfo.getId());
        model.addAttribute("nota",notaInfo);
        model.addAttribute("avaliacao", avaliacaoInfo);
        model.addAttribute("idAluno", nService.getAlunoId(notaInfo.getId()));
        model.addAttribute("comentarioP", cService.getComentarioProfessor(notaInfo.getId()));
        model.addAttribute("comentarioA", cService.getComentarioAluno(notaInfo.getId()));
        model.addAttribute("comentario", new ComentarioDTO());

        return "avaliacao/menuNota";
    }
}
