package devbootcamp.miniboss.demo.repository;

import devbootcamp.miniboss.demo.config.SpringJdbcConfig;
import devbootcamp.miniboss.demo.model.catFacts.Cat;
import devbootcamp.miniboss.demo.util.CatRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CatRepository {
    DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();
    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public int insert(Long id, Cat body) {
        return jdbcTemplate.update("INSERT INTO cat(user_id, cat_fact_id, cat_fact_text) VALUES(?,?,?)", id, body.get_id(), body.getText());
    }

    public List<Cat> selectAllFavorite(Long id) {
        return jdbcTemplate.query("SELECT * FROM cat WHERE user_id = ?", preparedStatement -> preparedStatement.setLong(1,id), new CatRowMapper());
    }

    public Cat selectFavorite(Long id, Long cat_id){
        return jdbcTemplate.queryForObject("SELECT * FROM cat WHERE id = ? AND user_id = ?", new Object[]{cat_id, id}, new CatRowMapper());
    }

    public int delete(Long id, Long cat_id) {
        return jdbcTemplate.update("DELETE FROM cat WHERE id = ? AND user_id = ?", cat_id, id);
    }
}
