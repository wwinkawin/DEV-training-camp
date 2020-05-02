package devbootcamp.miniboss.demo.repository;

import devbootcamp.miniboss.demo.config.SpringJdbcConfig;
import devbootcamp.miniboss.demo.model.User;
import devbootcamp.miniboss.demo.util.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepository {
    DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();
    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public int insert(User body) {
        return jdbcTemplate.update("INSERT INTO user(first_name, last_name) VALUES(?,?)",body.getFirstName(), body.getLastName());
    }

    public User select(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM user where id = ?", new Object[]{id}, new UserRowMapper());
    }
}
