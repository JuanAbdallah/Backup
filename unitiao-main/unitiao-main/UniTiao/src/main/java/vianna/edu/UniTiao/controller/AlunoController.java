package vianna.edu.UniTiao.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vianna.edu.UniTiao.model.dto.MateriaPorAlunosDTO;
import vianna.edu.UniTiao.model.dto.UserInfoDTO;
import vianna.edu.UniTiao.services.MateriaService;
import vianna.edu.UniTiao.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    UserService uService;
    @Autowired
    MateriaService mService;

    @GetMapping("")
    public String viewAlunos(Model model, @ModelAttribute UserInfoDTO alunoInfo) {
        model.addAttribute("lista", uService.getAllAlunos());
        model.addAttribute("aluno", alunoInfo);
        return "alunos/listaAlunos";
    }

    @GetMapping("/{nomeMateria}")
    public String viewAlunosByMateria(Model model, @PathVariable String nomeMateria, @ModelAttribute UserInfoDTO alunoInfo) {
        model.addAttribute("lista", uService.getAllAlunosByMateria(nomeMateria));
        model.addAttribute("alunos", uService.getAlunosSemMateria(nomeMateria));
        model.addAttribute("nomeMateria", nomeMateria);
        model.addAttribute("aluno", alunoInfo);

        return "alunos/listaAlunos";
    }

    @GetMapping("/cadMateria/{materia}")
    public String cadMateriaAluno(Model model, @PathVariable String materia, @ModelAttribute UserInfoDTO alunoInfo) {
        System.out.println(alunoInfo.getLogin());
        uService.cadMateria(alunoInfo.getLogin(), materia);
        return "redirect:/alunos/" + materia;
    }

    @GetMapping("/aluno/{id}")
    public String viewAvaliacaoAluno(Model model, @PathVariable int id) {
        return "avaliacao/alunoAvaliacao";
    }

    @GetMapping("/dashboard")
    public String getAlunosDashboard(Model model,@ModelAttribute List<MateriaPorAlunosDTO> alunos) {
        alunos = uService.getAlunosPorMateria();
        model.addAttribute("alunosPorMateria", alunos);
        return "dashboardAlunos";
    }

    @GetMapping("/{id}/{nomeMateria}")
    public String deleteAlunoFromMateria(Model model, @PathVariable int id, @PathVariable String nomeMateria) throws Exception {
        uService.deleteMateriaFromAluno(id, nomeMateria);
        mService.deleteAlunoFromMateria(nomeMateria, id);
        return "redirect:/alunos/" + nomeMateria;

    }
}
