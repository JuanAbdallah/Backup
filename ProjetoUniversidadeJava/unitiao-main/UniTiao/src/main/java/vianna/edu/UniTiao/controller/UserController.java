package vianna.edu.UniTiao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vianna.edu.UniTiao.model.Aluno;
import vianna.edu.UniTiao.model.Professor;
import vianna.edu.UniTiao.model.dao.AlunoDAO;
import vianna.edu.UniTiao.model.dao.ProfessorDAO;
import vianna.edu.UniTiao.model.dto.UserInfoDTO;
import vianna.edu.UniTiao.model.dto.UserResponseDTO;
import vianna.edu.UniTiao.services.UserService;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService uServ;
    @Autowired
    AlunoDAO alunoDAO;
    @Autowired
    ProfessorDAO professorDAO;

@GetMapping("")
    private String UsersList(Model model, @ModelAttribute UserInfoDTO users) {
    if (users.getNome() == null || users.getNome().isEmpty()) {

        model.addAttribute("listaAlunos", uServ.getAllAlunos());
        model.addAttribute("listaProfessores", uServ.getAllProfessores());
    } else {
        model.addAttribute("listaAlunos", uServ.searchAlunoByNome(users.getNome()));
        model.addAttribute("listaProfessores", uServ.searchProfessorByNome(users.getNome()));
    }
    model.addAttribute("users", users);
    return "usuario/usersList";
    }
    @GetMapping("/new")
    public String viewSaveUser(Model model, @ModelAttribute UserInfoDTO infos){

        model.addAttribute("infos", infos);
        return "usuario/novoUser";
    }


    @PostMapping("")
    public String saveUser(Model model, @ModelAttribute UserInfoDTO infos){
        try {
            System.out.println(infos.getTipo());
            uServ.saveNewUser(infos);
            return "redirect:/user";
        } catch (Exception e) {
            model.addAttribute("infos", infos);
            model.addAttribute("erro", e.getMessage());
            return "usuario/novoUser";
        }

    }

    @GetMapping("/delete/{tipo}/{login}")
    public String deleteUser(Model model,  @PathVariable String login, @PathVariable String tipo){
        try{
            System.out.println(login);
            UserInfoDTO infos = new UserInfoDTO();
            infos.setLogin(login);
            infos.setTipo(tipo);
            uServ.deleteUser(infos);

            return "redirect:/user";
        }catch (Exception e){
            model.addAttribute("erro", e.getMessage());
            return "redirect:/user";
        }
    }
    @GetMapping("/edit/{login}/{tipo}")
    public String alteraView(Model model, @PathVariable String login, @PathVariable String tipo) {
        UserInfoDTO infos = new UserInfoDTO();
        if ("ALUNO".equals(tipo)) {
            Aluno aluno = alunoDAO.findByLogin(login);
            infos.setId(aluno.getId());
            infos.setNome(aluno.getNome());
            infos.setEmail(aluno.getEmail());
            infos.setLogin(aluno.getLogin());
            infos.setSenha(aluno.getSenha());

            infos.setTipo("ALUNO");

        } else {
            Professor professor = professorDAO.findByLogin(login);
            infos.setId(professor.getId());
            infos.setNome(professor.getNome());
            infos.setEmail(professor.getEmail());
            infos.setLogin(professor.getLogin());
            infos.setSenha(professor.getSenha());
            infos.setTipo("PROFESSOR");
        }
        model.addAttribute("infos", infos);
        return "usuario/editaUser";
    }


    @PostMapping("/update")
    public String alteraUser(Model model, @ModelAttribute UserInfoDTO infos) {
        try {
            System.out.println(infos.getNome());
            uServ.alteraUser(infos);
            return "redirect:/user";
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("infos", infos);
            return "usuario/editaUser";
        }
    }

}




