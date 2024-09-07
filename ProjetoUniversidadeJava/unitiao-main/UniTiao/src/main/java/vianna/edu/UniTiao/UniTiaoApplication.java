package vianna.edu.UniTiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vianna.edu.UniTiao.model.*;
import vianna.edu.UniTiao.model.dao.*;

import java.util.Date;

@SpringBootApplication
public class UniTiaoApplication implements CommandLineRunner {

	@Autowired
	private AdminDAO admin;

	@Autowired MateriaDAO md;

	@Autowired
	AvaliacaoDAO ar;
	@Autowired
	ComentarioProfessorDAO cpr ;
	@Autowired
	ComentarioAlunoDAO car;

	@Bean
	public PasswordEncoder ps() {
		return new BCryptPasswordEncoder();
	}


	public static void main(String[] args) {
		SpringApplication.run(UniTiaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		initializeData();
	}

	private void initializeData() {
		try {
			Admin adminUser = new Admin();
			adminUser.setNome("Admin");
			adminUser.setEmail("admin@gmail.com");
			adminUser.setLogin("admin");
			adminUser.setDataUltimoAcesso(new Date());
			adminUser.setSenha(ps().encode("123"));
			admin.save(adminUser);

			System.out.println("Administrador criado com sucesso!");
		} catch (Exception e) {
			System.err.println("Erro ao inicializar dados: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
