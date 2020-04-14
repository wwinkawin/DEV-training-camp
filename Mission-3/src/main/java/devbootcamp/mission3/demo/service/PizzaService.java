package devbootcamp.mission3.demo.service;

import devbootcamp.mission3.demo.util.PizzaRowMapper;
import devbootcamp.mission3.demo.config.SpringJdbcConfig;
import devbootcamp.mission3.demo.model.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class PizzaService {

    //Initialize Data source
    DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public List<Pizza> retrievePizza() {
        return jdbcTemplate.query("SELECT * FROM menu", new PizzaRowMapper());
    }

    public void createPizza(Pizza pizza) {
        jdbcTemplate.update("INSERT INTO menu(menu, extra_topping, is_favorite) VALUES (?, ?, ?)", pizza.getMenu(),
                pizza.getExtraTopping(), pizza.isFavorite());
    }

    public void updatePizza(Long id, Pizza pizza) {
        jdbcTemplate.update("UPDATE menu set menu = ?, extra_topping = ?, is_favorite = ? where id = ?",
                 pizza.getMenu(), pizza.getExtraTopping(), pizza.isFavorite(),id);
    }

    public void deletePizza(Long id) {
        jdbcTemplate.update("DELETE FROM menu WHERE id = ?", id);
    }
}
