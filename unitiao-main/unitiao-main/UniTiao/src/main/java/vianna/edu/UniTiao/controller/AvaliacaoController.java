package vianna.edu.UniTiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vianna.edu.UniTiao.model.Comentario;
import vianna.edu.UniTiao.model.Nota;
import vianna.edu.UniTiao.model.dto.AvaliacaoDTO;
import vianna.edu.UniTiao.model.dto.ComentarioDTO;
import vianna.edu.UniTiao.model.dto.NotaDTO;
import vianna.edu.UniTiao.services.*;

@Controller
@RequestMapping("/avaliacao")
public class AvaliacaoController {
    @Autowired
    AvaliacaoService aService;
    @Autowired
    MateriaService mService;
    @Autowired
    UserService uService;
    @Autowired
    NotaService nService;
    @Autowired
    ComentarioService cService;

    @GetMapping("")
    private String avaliacaoList(Model model, @ModelAttribute AvaliacaoDTO avaliacoes) {
        model.addAttribute("avaliacoes", aService.getAll());
        return "avaliacao/listaAvaliacao";
    }

    @GetMapping("/new/{materia}")
    private String addView(Model model, @ModelAttribute AvaliacaoDTO avaliacao, @PathVariable String materia) {
        model.addAttribute("list", mService.getAllMaterias());
        model.addAttribute("materia", materia);
        model.addAttribute("avaliacao", avaliacao);
        return "avaliacao/novaAvaliacao";
    }

    @GetMapping("/save/{nomeMateria}")
    public String saveNewAvaliacao(Model model, @ModelAttribute AvaliacaoDTO avaliacao,@PathVariable String nomeMateria) {
        System.out.println("imprimir data do avaliacaoController: " + avaliacao.getData());
        System.out.println("nome materia: " + nomeMateria);

        try {
            aService.saveAvaliacao(avaliacao,nomeMateria);
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "avaliacao/novaAvaliacao";
        }
        return "redirect:/alunos/" + nomeMateria;
    }

    @GetMapping("/editar/{id}")
    private String alteraView(Model model, @PathVariable int id) throws Exception {
        try {
            model.addAttribute("avaliacao", aService.getInfos(id));
            model.addAttribute("list", mService.getAllMaterias());
            return "avaliacao/editAvaliacao";
        } catch (Exception e) {
            throw new Exception("erro");
        }
    }

    @PostMapping("/update")
    private String saveAlteracao(Model model, @ModelAttribute AvaliacaoDTO avaliacao) throws Exception {
        aService.alterar(avaliacao);
        return "redirect:/avaliacao";
    }

    @GetMapping("/excluir/{id}")
    private String deleteAvaliacao(Model model, @PathVariable int id) {
        try {
            aService.deleteAvaliacao(id);
            return "redirect:/avaliacao";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "redirect:/avaliacao";
        }
    }

    @GetMapping("/{nomeMateria}/{id}")
    private String viewAvaliacaoByAlunoAndMateria(Model model, @PathVariable String nomeMateria, @PathVariable int id) {
        model.addAttribute("avaliacoes", aService.getAvaliacaoByAlunoAndMateria(nomeMateria, id));
        model.addAttribute("nota", nService.getNotaByAluno(id));
        model.addAttribute("idAluno", id);
        return "avaliacao/listaAvaliacaoAluno";
    }
    @GetMapping("/avaliacao={id}/aluno={idAluno}")
    private String menuNotaView (Model model, @PathVariable int id, @PathVariable int idAluno) throws Exception {
        NotaDTO notaInfo = nService.getNotaAvaliacao(id, idAluno);
        AvaliacaoDTO avaliacaoInfo = aService.getAvaliacaoById(id);
        model.addAttribute("nota", notaInfo);
        model.addAttribute("avaliacao", avaliacaoInfo);
        model.addAttribute("idAluno", idAluno);
        model.addAttribute("comentarioP", cService.getComentarioProfessor(notaInfo.getId()));
        model.addAttribute("comentarioA", cService.getComentarioAluno(notaInfo.getId()));
        model.addAttribute("comentario", new ComentarioDTO());
        System.out.println(aService.getAvaliacaoById(id).getNota());

        return "avaliacao/menuNota";
    }
    @PostMapping("/saveNota/{idAvaliacao}/{idAluno}")
    public String saveMenuNota(Model model, @ModelAttribute NotaDTO nota, @PathVariable int idAvaliacao, @PathVariable int idAluno) throws Exception {
        System.out.println(nota);
        System.out.println(idAvaliacao);
        System.out.println(idAluno);
        nService.saveNota(nota, idAvaliacao, idAluno);
        model.addAttribute("nota", nService.getNotaAvaliacao(idAvaliacao, idAluno));
        model.addAttribute("avaliacao", aService.getAvaliacaoById(idAvaliacao));
        model.addAttribute("idAluno", idAluno);
        return "redirect:/avaliacao/avaliacao="+idAvaliacao+"/aluno="+idAluno;
    }
    @GetMapping("/aluno/{nomeMateria}")
    private String viewAvaliacaoByAluno(Model model, @PathVariable String nomeMateria){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("avaliacoes", aService.getAvaliacaoByAlunoAndMateria(nomeMateria, auth.getName()));
        model.addAttribute("idAluno", uService.getAlunoByLogin(auth.getName()).getId());
        System.out.println(aService.getAvaliacaoByAlunoAndMateria(nomeMateria, auth.getName()).get(0).getNota());
        return "avaliacao/listaAvaliacaoAluno";
    }
}
