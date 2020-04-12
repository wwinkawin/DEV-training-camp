package devbootcamp.mission2.demo;

import devbootcamp.mission2.demo.exception.BookIdMismatchException;
import devbootcamp.mission2.demo.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    @GetMapping()
    public List<Pizza> getPizza() {
        return pizzaService.retrievePizza();
    }

    @PostMapping()
    public ResponseEntity<?> postPizza(@RequestBody Pizza body) {
        Pizza pizza = pizzaService.createPizza(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putPizza(@PathVariable Long id, @RequestBody Pizza body) {
        Optional<Pizza> pizza = pizzaService.updatePizza(id, body);
        if(!pizza.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        if(!pizzaService.deletePizza(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}