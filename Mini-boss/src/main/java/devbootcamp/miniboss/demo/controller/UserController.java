package devbootcamp.miniboss.demo.controller;

import devbootcamp.miniboss.demo.model.User;
import devbootcamp.miniboss.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> postFavorite(@RequestBody User body){
        userService.createUser(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

}
