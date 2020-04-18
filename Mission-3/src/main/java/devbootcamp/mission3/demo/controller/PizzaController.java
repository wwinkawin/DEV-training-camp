package devbootcamp.mission3.demo.controller;

import devbootcamp.mission3.demo.model.Pizza;
import devbootcamp.mission3.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getPizza(@PathVariable Long id) {
        Optional<Pizza> pizza = pizzaService.retrievePizza(id);
        if (pizza.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(pizza);
        }

    }

    @PostMapping()
    public ResponseEntity<?> postPizza(@RequestBody Pizza body) {
        //If 0 rows affected, return NOT_FOUND
        if (pizzaService.createPizza(body) == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        //Else returned created
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putPizza(@PathVariable Long id, @RequestBody Pizza body) {
        if (pizzaService.updatePizza(id, body) == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePizza(@PathVariable Long id) {
        if (pizzaService.deletePizza(id) == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
        } else {
            return ResponseEntity.ok().build();
        }
    }
}