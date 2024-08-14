package vianna.edu.UniTiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vianna.edu.UniTiao.model.dto.MateriaPorAlunosDTO;
import vianna.edu.UniTiao.model.dto.UserResponseDTO;
import vianna.edu.UniTiao.model.dto.UserSecurityDetails;
import vianna.edu.UniTiao.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
@Autowired
    UserService uService;
    @GetMapping("")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/nome")
    public ResponseEntity<String> getNomeUsuario(Authentication auth) {
        UserSecurityDetails userInfo = (UserSecurityDetails) auth.getPrincipal();
        String nomeUsuario = userInfo.getNome();
        return ResponseEntity.ok(nomeUsuario);
    }
    @GetMapping("/dashboard")
    public String getAlunosDashboard(Model model ) {
        List<MateriaPorAlunosDTO> alunos = uService.getAlunosPorMateria();
        model.addAttribute("alunosPorMateria", alunos);
        return "dashboardAlunos";
    }

    @GetMapping("/login")
    public String login(){return "login";}
}
