package vianna.edu.UniTiao.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vianna.edu.UniTiao.model.Admin;

import java.util.List;


public interface AdminDAO extends JpaRepository<Admin, Integer> {
    public Admin findByLogin(String login);

}
