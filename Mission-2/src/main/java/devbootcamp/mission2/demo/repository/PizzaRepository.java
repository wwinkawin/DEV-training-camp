package devbootcamp.mission2.demo.repository;

import devbootcamp.mission2.demo.model.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}