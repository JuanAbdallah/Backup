package vianna.edu.UniTiao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vianna.edu.UniTiao.model.*;
import vianna.edu.UniTiao.model.dao.*;
import vianna.edu.UniTiao.model.dto.MateriaPorAlunosDTO;
import vianna.edu.UniTiao.model.dto.UserInfoDTO;
import vianna.edu.UniTiao.model.dto.UserSecurityDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AlunoDAO alunoDAO;

    @Autowired
    ProfessorDAO professorDAO;

    @Autowired
    AdminDAO adminDAO;

    @Autowired
    MateriaDAO materiaDAO;

    @Autowired
    PasswordEncoder pass;
    @Autowired
    NotaDAO notaDAO;
    @Autowired
    AvaliacaoDAO avaliacaoDAO;
    @Autowired
    ComentarioDAO cDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno a = alunoDAO.findByLogin(username);

        if (a != null) {
            return new UserSecurityDetails(a);
        } else {
            Professor p = professorDAO.findByLogin(username);
            if (p != null) {
                return new UserSecurityDetails(p);

            } else {
                Admin adm = adminDAO.findByLogin(username);
                if (adm != null) {
                    return new UserSecurityDetails(adm);
                }
                throw new UsernameNotFoundException("Usuário nao encontrado");
            }
        }
    }

    public List<UserInfoDTO> getAllUsers() {

        List<Aluno> listaAluno = alunoDAO.findAll();
        List<Professor> listaProfessor = professorDAO.findAll();
        List<Admin> listaAdm = adminDAO.findAll();

        List<UserInfoDTO> users = new ArrayList<>();

        listaAluno.forEach(a -> users.add(convertToUserInfoDTO(a)));
        listaProfessor.forEach(p -> users.add(convertToUserInfoDTO(p)));
        listaAdm.forEach(adm -> users.add(convertToUserInfoDTO(adm)));

        return users;

    }

    @Transactional
    public void saveNewUser(UserInfoDTO infos) throws Exception {

        if (infos.getTipo().equals("ALUNO")) {
            if (verifyLogin(infos.getLogin())) {
                Aluno a = new Aluno();
                a.setNome(infos.getNome());
                a.setEmail(infos.getEmail());
                a.setLogin(infos.getLogin());
                a.setSenha(pass.encode(infos.getSenha()));
                a.setDataUltimoAcesso(new Date());

                alunoDAO.save(a);
            } else {
                throw new Exception("Login inválido: este login já existe!");
            }

        } else if (infos.getTipo().equals("PROFESSOR")) {
            if (verifyLogin(infos.getLogin())) {
                Professor p = new Professor(null, null);
                p.setNome(infos.getNome());
                p.setEmail(infos.getEmail());
                p.setLogin(infos.getLogin());
                p.setSenha(pass.encode(infos.getSenha()));
                p.setDataUltimoAcesso(new Date());

                professorDAO.save(p);
            } else {
                throw new Exception("Login inválido: este login já existe!");
            }
        } else {
            throw new Exception("tipo de usuário inválido");
        }
    }

    @Transactional
    public void deleteUser(UserInfoDTO infos) throws Exception {
        if (infos.getTipo().equals("ALUNO")) {
            Aluno a = alunoDAO.findByLogin(infos.getLogin());
            if (!a.getMaterias().isEmpty()) {
                excluirAlunoDaMateria(a);
            }

            System.out.println(a.getId());
            alunoDAO.delete(a);
        } else if (infos.getTipo().equals("PROFESSOR")) {
            Professor p = professorDAO.findByLogin(infos.getLogin());
            System.out.println(p.getId());

            professorDAO.delete(p);
        } else {
            throw new Exception("Não foi possível deletar");
        }
    }

    private void excluirAlunoDaMateria(Aluno a) {
        for (Materia m :
                a.getMaterias()) {
            m.getAlunos().remove(a);
        }
    }

    private boolean verifyLogin(String login) {
        return alunoDAO.findByLogin(login) == null && professorDAO.findByLogin(login) == null;
    }

    public void alteraUser(UserInfoDTO infos) throws Exception {
        if ("ALUNO".equals(infos.getTipo())) {
            Aluno aluno = alunoDAO.findById(infos.getId());
            aluno.setLogin(infos.getLogin());
            aluno.setNome(infos.getNome());
            aluno.setEmail(infos.getEmail());
            aluno.setSenha(pass.encode(infos.getSenha()));
            alunoDAO.save(aluno);
        } else if (infos.getTipo().equals("PROFESSOR")) {
            Professor professor = professorDAO.findById(infos.getId());
            professor.setLogin(infos.getLogin());
            professor.setNome(infos.getNome());
            professor.setEmail(infos.getEmail());
            professor.setSenha(pass.encode(infos.getSenha()));
            professorDAO.save(professor);
        } else {
            throw new Exception("Não foi possível alterar");
        }
    }

    public List<UserInfoDTO> getAllAlunos() {
        List<Aluno> listaAluno = alunoDAO.findAll();
        List<UserInfoDTO> alunoInfosLista = new ArrayList<>();
        listaAluno.forEach(a -> alunoInfosLista.add(
                new UserInfoDTO(a.getId(), a.getNome(), a.getEmail(),
                        a.getLogin(), a.getSenha(), "ALUNO")
        ));

        return alunoInfosLista;
    }

    public List<UserInfoDTO> getAllAlunosByMateria(String nomeMateria) {
        Materia materia = materiaDAO.findByNome(nomeMateria);
        List<Aluno> alunos = materia.getAlunos();

        List<UserInfoDTO> alunoInfosLista = new ArrayList<>();
        alunos.forEach(a -> alunoInfosLista.add(
                new UserInfoDTO(a.getId(), a.getNome(), a.getEmail(),
                        a.getLogin(), a.getSenha(), "ALUNO")
        ));

        return alunoInfosLista;

    }

    public List<UserInfoDTO> getAllProfessores() {
        List<Professor> listaProfessor = professorDAO.findAll();
        List<UserInfoDTO> professorInfosLista = new ArrayList<>();
        listaProfessor.forEach(p -> professorInfosLista.add(
                new UserInfoDTO(p.getId(), p.getNome(), p.getEmail(),
                        p.getLogin(), p.getSenha(), "PROFESSOR")
        ));

        return professorInfosLista;
    }

    public List<UserInfoDTO> searchAlunoByNome(String nome) {
        List<UserInfoDTO> alunosInfoLista = new ArrayList<>();
        List<Aluno> alunoLista = alunoDAO.findByNomeContainingIgnoreCase(nome);
        alunoLista.forEach(a -> alunosInfoLista.add(
                convertToUserInfoDTO(a)
        ));

        return alunosInfoLista;
    }

    public List<UserInfoDTO> searchProfessorByNome(String nome) {
        List<UserInfoDTO> professoresInfoLista = new ArrayList<>();
        List<Professor> professorLista = professorDAO.findByNomeContainingIgnoreCase(nome);
        professorLista.forEach(p -> professoresInfoLista.add(
                convertToUserInfoDTO(p))
        );

        return professoresInfoLista;
    }

    @Transactional
    public void cadMateria(String login, String materia) {
        Aluno a = alunoDAO.findByLogin(login);
        Materia m = materiaDAO.findByNome(materia);
        if (m.getAvaliacoes() != null) {
            for (Avaliacao avaliacao :
                    m.getAvaliacoes()) {
                Nota nota = new Nota();
                ComentarioProfessor cp = new ComentarioProfessor();
                ComentarioAluno ca = new ComentarioAluno();

                nota.setAluno(a);
                nota.setAvaliacao(avaliacao);

                cp.setProfessor(avaliacao.getMateria().getProfessor());
                cp.setNota(nota);
                nota.setComentarioProfessor(cp);

                ca.setAluno(a);
                ca.setNota(nota);
                nota.setComentarioAluno(ca);

                avaliacao.getNotas().add(nota);
                a.getNotas().add(nota);

                notaDAO.save(nota);
                avaliacaoDAO.save(avaliacao);
                cDAO.save(ca);
                cDAO.save(cp);
            }
        }

        a.addMateria(m);
        alunoDAO.save(a);

    }

    private UserInfoDTO convertToUserInfoDTO(Professor professor) {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setTipo("PROFESSOR");
        dto.setEmail(professor.getEmail());
        dto.setLogin(professor.getLogin());
        return dto;
    }

    private UserInfoDTO convertToUserInfoDTO(Admin admin) {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(admin.getId());
        dto.setNome(admin.getNome());
        dto.setTipo("ADMIN");
        dto.setEmail(admin.getEmail());
        dto.setLogin(admin.getLogin());
        return dto;
    }

    private UserInfoDTO convertToUserInfoDTO(Aluno aluno) {
        UserInfoDTO dto = new UserInfoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setTipo("ALUNO");
        dto.setEmail(aluno.getEmail());
        dto.setLogin(aluno.getLogin());
        return dto;
    }

    public List<UserInfoDTO> getAlunosSemMateria(String nomeMateria) {
        List<UserInfoDTO> alunosInfoLista = new ArrayList<>();
        List<Aluno> alunoLista = alunoDAO.findAll();

        for (Aluno aluno : alunoLista) {
            boolean possuiMateria = false;

            for (Materia materia : aluno.getMaterias()) {
                if (materia.getNome().equalsIgnoreCase(nomeMateria)) {
                    possuiMateria = true;
                    break;
                }
            }

            if (!possuiMateria) {
                alunosInfoLista.add(convertToUserInfoDTO(aluno));
            }
        }

        return alunosInfoLista;
    }

    public List<MateriaPorAlunosDTO> getAlunosPorMateria() {
        List<Materia> materias = materiaDAO.findAll();
        List<MateriaPorAlunosDTO> dtos = materias.stream().map(materia -> new MateriaPorAlunosDTO(
                materia.getNome(),
                materia.getAlunos().size()
        )).collect(Collectors.toList());


        System.out.println(dtos);

        return dtos;
    }


    public Aluno getAlunoByLogin(String login) {
        return alunoDAO.findByLogin(login);
    }

    public void deleteMateriaFromAluno(int id, String nomeMateria) throws Exception {
        Aluno aluno = alunoDAO.findById(id);
        if (aluno != null) {
            for (Materia m :
                    aluno.getMaterias()) {
                if (m.getNome().equals(nomeMateria)) {
                    aluno.getMaterias().remove(m);
                    break;
                }
            }
            alunoDAO.save(aluno);
        } else {
            throw new Exception("Erro ao buscar aluno");
        }
    }

}

