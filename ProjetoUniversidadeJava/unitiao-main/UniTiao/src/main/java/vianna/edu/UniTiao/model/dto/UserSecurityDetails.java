package vianna.edu.UniTiao.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import vianna.edu.UniTiao.model.Admin;
import vianna.edu.UniTiao.model.Aluno;
import vianna.edu.UniTiao.model.Professor;
import vianna.edu.UniTiao.model.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserSecurityDetails implements UserDetails {
    private Usuario usuario;

    public UserSecurityDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> listaAutorizados = new ArrayList<>();

        if(usuario instanceof Aluno){
            listaAutorizados.add(new SimpleGrantedAuthority("ROLE_ALUNO"));
        }
        if (usuario instanceof Professor){
            listaAutorizados.add(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
        }
        if (usuario instanceof Admin){
            listaAutorizados.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        }
        listaAutorizados.add(new SimpleGrantedAuthority("ROLE_USER"));

        return listaAutorizados;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getLogin();
    }

    public String getNome(){
        return usuario.getNome();
    }

}
