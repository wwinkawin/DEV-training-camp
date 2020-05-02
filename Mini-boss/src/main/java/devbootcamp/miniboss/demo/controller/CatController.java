package devbootcamp.miniboss.demo.controller;


import devbootcamp.miniboss.demo.exceptionhandling.CatServiceException;
import devbootcamp.miniboss.demo.model.catFacts.Cat;
import devbootcamp.miniboss.demo.service.CatService;
import devbootcamp.miniboss.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/{id}")
public class CatController {

    @Autowired
    CatService catService;

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<?> getCat(@PathVariable Long id) throws CatServiceException {
        if (userService.checkExistingUser(id)) {
            return ResponseEntity.ok(catService.getAll());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/favorite")
    public ResponseEntity<?> getAllFavoriteCat(@PathVariable Long id) {
        if (userService.checkExistingUser(id)) {
            return ResponseEntity.ok(catService.getAllFavorite(id));
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/favorite/{cat_id}")
    public ResponseEntity<?> getFavoriteCat(@PathVariable Long id, @PathVariable Long cat_id) {
        if (userService.checkExistingUser(id)) {
            return ResponseEntity.ok(catService.getFavorite(id, cat_id));
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<?> postCat(@PathVariable Long id, @Valid @RequestBody Cat body) throws CatServiceException {
        if (userService.checkExistingUser(id)) {
            catService.createCat(id, body);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/favorite/{cat_id}")
    public ResponseEntity<?> deleteCat(@PathVariable Long id, @PathVariable Long cat_id) throws CatServiceException {
        if (userService.checkExistingUser(id)) {
            catService.deleteCat(id, cat_id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
