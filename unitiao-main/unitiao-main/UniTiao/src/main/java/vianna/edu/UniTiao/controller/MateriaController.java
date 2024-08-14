package vianna.edu.UniTiao.controller;

import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vianna.edu.UniTiao.model.dto.MateriaDTO;
import vianna.edu.UniTiao.services.MateriaService;
import vianna.edu.UniTiao.services.UserService;

@Controller
@RequestMapping("/materias")
public class MateriaController {
    @Autowired
    MateriaService mServ;

    @Autowired
    UserService uService;
    @GetMapping("")
    private String materiaList(Model model, @ModelAttribute MateriaDTO materiaInfos){
        if(materiaInfos.getNome() == null || materiaInfos.getNome().isEmpty()){
            model.addAttribute("lista", mServ.getAllMaterias());
        }else{
            model.addAttribute("errorMessage", "deu erro paizao!");
        }
        model.addAttribute("materias", materiaInfos);

        return "materias/listMaterias";
    }
    @GetMapping("/new")
    private String viewSaveMateira(Model model, @ModelAttribute MateriaDTO materiaInfo){
        model.addAttribute("materia", materiaInfo);
        model.addAttribute("professores",uService.getAllProfessores());
        return ("materias/novaMateria");
    }
    @PostMapping("")
    private String saveMateria(Model model, @ModelAttribute MateriaDTO materiaInfo){
        try {
            mServ.saveMateria(materiaInfo);

            return "redirect:/materias";
        }catch (Exception e){
            model.addAttribute("erro", e.getMessage());
            return "redirect:/materias";
        }
    }

    @GetMapping("/delete/{id}")
    private String deleteMateria(Model model, @PathVariable int id){
        try{
            mServ.deleteMateria(id);
            return "redirect:/materias";
        }catch (Exception e){
            model.addAttribute("erro", e.getMessage());
            return "redirect:/materias";
        }
    }

    @GetMapping("/edit/{id}")
    private String viewEditMateria(Model model, @PathVariable int id){
        try{
            model.addAttribute("materia", mServ.getMateriaInfo(id));
            model.addAttribute("professores",uService.getAllProfessores());
            return "materias/editaMateria";
        }catch (Exception e){
            model.addAttribute("erro", e.getMessage());
            return "redirect:/materias";
        }
    }

    @PostMapping("/update")
    private String alteraMateria(Model model, @ModelAttribute MateriaDTO materiaInfo){
        try{
            mServ.alteraMateria(materiaInfo);

            return "redirect:/materias";
        }catch (Exception e){
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("materia", materiaInfo);

            return "materias/editaMateria";
        }
    }
    @GetMapping("/aluno")
    private String viewMateriaByAluno(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("lista", mServ.getAllMateriasByAluno(auth.getName()));
        return "materias/listMaterias";
    }
    @GetMapping("/professor")
    private String viewMateriaByProfessor(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            model.addAttribute("lista", mServ.getAllMateriasByProfessor(auth.getName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "materias/listMaterias";
    }
}
