package devbootcamp.mission3.demo.repository;

import devbootcamp.mission3.demo.config.SpringJdbcConfig;
import devbootcamp.mission3.demo.model.Pizza;
import devbootcamp.mission3.demo.util.PizzaRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SqlRepository {
    //Initialize Data source
    DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    //Select ALL method
    public List<Pizza> selectAll() {
        return jdbcTemplate.query("SELECT * FROM menu", new PizzaRowMapper());
    }

    //Select 1 row method
    public Pizza select(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM menu WHERE id = ?", new Object[]{id}, new PizzaRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int insert(Pizza pizza) {
        return jdbcTemplate.update("INSERT INTO menu(menu, extra_topping, is_favorite) VALUES (?, ?, ?)", pizza.getMenu(),
                pizza.getExtraTopping(), pizza.isFavorite());
    }

    public int update(Long id, Pizza pizza) {
        return jdbcTemplate.update("UPDATE menu set menu = ?, extra_topping = ?, is_favorite = ? where id = ?",
                pizza.getMenu(), pizza.getExtraTopping(), pizza.isFavorite(), id);
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM menu WHERE id = ?", id);
    }
}
