package devbootcamp.mission3.demo.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import devbootcamp.mission3.demo.repository.SqlRepository;
import devbootcamp.mission3.demo.util.PizzaRowMapper;
import devbootcamp.mission3.demo.config.SpringJdbcConfig;
import devbootcamp.mission3.demo.model.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    //Initialize Data source
    DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    SqlRepository repo = new SqlRepository();

    public List<Pizza> retrievePizza() {
        return repo.selectAll();
    }

    public Optional<Pizza> retrievePizza(Long id) {
        return Optional.ofNullable(repo.select(id));
    }

    public int createPizza(Pizza pizza) {
        return repo.insert(pizza);
    }

    public int updatePizza(Long id, Pizza pizza) {
        return repo.update(id, pizza);
    }

    public int deletePizza(Long id) {
        return repo.delete(id);
    }
}
