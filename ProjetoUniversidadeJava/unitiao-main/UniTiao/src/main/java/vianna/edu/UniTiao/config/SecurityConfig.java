//package vianna.edu.UniTiao.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import vianna.edu.UniTiao.services.UserService;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//    @Autowired
//    PasswordEncoder pass;
//
//    @Lazy
//    @Autowired
//    private UserService userDetailsService;
//
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(pass);
//
//        return authenticationManagerBuilder.build();
//    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/style.css", "/css/**", "/images/**", "/js/**");
//    }
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorize) -> authorize
//                .requestMatchers("/", "/negado").permitAll()
//                .requestMatchers("/user/cadastro").hasAuthority("CADUSER")
//                .requestMatchers(
//                        "/avaliacao/save/","/avaliacao/aluno/","avaliacao/editar/","/avaliacao/excluir/","/avaliacao/saveNota/","/avaliacao/update",
//                        "materias/edit/","materias/professor"
//                ).hasAuthority("ROLE_PROFESSOR")
//                .requestMatchers("/avaliacao/save/","/avaliacao/","/avaliacao/aluno/","avaliacao/editar/","/avaliacao/excluir/","/avaliacao/saveNota/","/avaliacao/update"
//                        ,"materias/edit/","materias/","materias/aluno","materias/delete/","materias/new","materias/professor","materias/update","alunos/cadMateria/",
//                        "/user/new","user/edit/","user/delete/","user/update","user/"
//                ).hasAuthority("ROLE_ADMIN")
//                .anyRequest().authenticated()
//        ).formLogin((form) -> form
//                .loginPage("/login")
//                .defaultSuccessUrl("/", true)
//                .failureUrl("/login?error=true")
//                .permitAll()
//        ).logout((logout) -> logout
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/?logout")
//                .deleteCookies("JSESSIONID")
//                .permitAll()
//        ).exceptionHandling((ex) -> ex
//                .accessDeniedPage("/negado")
//        );
//        return http.build();
//    }
//}
package vianna.edu.UniTiao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import vianna.edu.UniTiao.services.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    PasswordEncoder pass;

    @Lazy
    @Autowired
    private UserService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(pass);

        return authenticationManagerBuilder.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/style.css", "/css/**", "/images/**", "/js/**");
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/", "/negado").permitAll()
                .requestMatchers("/user/cadastro").hasAuthority("CADUSER")
                .requestMatchers("/materias/**", "/avaliacao/**","/nome").hasAnyAuthority("ROLE_ALUNO", "ROLE_PROFESSOR", "ROLE_ADMIN")
                .requestMatchers("/user/**", "/materias/new", "/materias/edit", "/materias/delete").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/comentario/aluno/**").hasAnyAuthority("ROLE_ALUNO")
                .requestMatchers("/**").hasAnyAuthority("ROLE_PROFESSOR", "ROLE_ADMIN")
                .anyRequest().authenticated()
        ).formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error=true")
                .permitAll()
        ).logout((logout) -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/?logout")
                .deleteCookies("JSESSIONID")
                .permitAll()
        ).exceptionHandling((ex) -> ex
                .accessDeniedPage("/negado")
        );
        return http.build();
    }
}