package devbootcamp.mission3.demo.service;

import devbootcamp.mission3.demo.PizzaRowMapper;
import devbootcamp.mission3.demo.config.SpringJdbcConfig;
import devbootcamp.mission3.demo.model.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class PizzaService {

    //Initialize Data source
    DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();

    //Initialize SQL call and insert operators
    SimpleJdbcInsert simpleJdbcInsert =
            new SimpleJdbcInsert(dataSource).withTableName("menu").usingGeneratedKeyColumns("id");
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getPizza");

    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public List<Pizza> retrievePizza() {
        return jdbcTemplate.query("SELECT * FROM menu", new PizzaRowMapper());
    }

    public void createPizza(Pizza pizza) {
        System.out.println(pizza.isFavorite());
        jdbcTemplate.update("INSERT INTO menu(menu, extra_topping, is_favorite) VALUES (?, ?, ?)", pizza.getMenu(),
                pizza.getExtraTopping(), pizza.isFavorite());
    }

    public void updatePizza(Long id, Pizza pizza) {
        jdbcTemplate.update("UPDATE menu set menu = ?, extra_topping = ?, is_favorite = ? where id = ?",
                 pizza.getMenu(), pizza.getExtraTopping(), pizza.isFavorite(),id);

        /*Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);
        if (!pizzaOptional.isPresent()) {
            return pizzaOptional;
        }
        pizza.setId(id);
        return Optional.of(pizzaRepository.save(pizza));*/
    }

    public void deletePizza(Long id) {
        jdbcTemplate.update("DELETE FROM menu WHERE id = ?", id);
    }
}
