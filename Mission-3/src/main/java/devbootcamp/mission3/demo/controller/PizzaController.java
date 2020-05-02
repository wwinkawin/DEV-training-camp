package devbootcamp.mission3.demo.controller;

import devbootcamp.mission3.demo.exceptionhandling.PizzaServiceException;
import devbootcamp.mission3.demo.model.Pizza;
import devbootcamp.mission3.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    @GetMapping()
    public List<Pizza> getPizza() {
        return pizzaService.retrievePizza();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPizza(@PathVariable Long id) {
        Pizza pizza = pizzaService.retrievePizza(id);
        return ResponseEntity.ok(pizza);
    }

    @PostMapping()
    public ResponseEntity<?> postPizza(@RequestBody Pizza body) throws PizzaServiceException {
        pizzaService.createPizza(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putPizza(@PathVariable Long id, @RequestBody Pizza body) throws PizzaServiceException {
        pizzaService.updatePizza(id, body);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.ok().build();
    }
}