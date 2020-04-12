package devbootcamp.mission2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    private PizzaRepository  pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository repository) {
        this.pizzaRepository = repository;
    }

    public List<Pizza> retrievePizza() {
        return (List<Pizza>) pizzaRepository.findAll();
    }

    public Pizza createPizza(Pizza pizza) {
        pizza.setId(null);
        return pizzaRepository.save(pizza);
    }

    public Optional<Pizza> updatePizza(Long id, Pizza pizza) {
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);
        if(!pizzaOptional.isPresent()){
            return pizzaOptional;
        }
        pizza.setId(id);
        return Optional.of(pizzaRepository.save(pizza));
    }

    public boolean deletePizza(Long id) {
        try {
            pizzaRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
