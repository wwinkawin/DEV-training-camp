package devbootcamp.mission3.demo.service;

import devbootcamp.mission3.demo.repository.PizzaRepository;
import devbootcamp.mission3.demo.config.SpringJdbcConfig;
import devbootcamp.mission3.demo.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    PizzaRepository repo = new PizzaRepository();

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
