package devbootcamp.miniboss.demo.service;

import devbootcamp.miniboss.demo.exceptionhandling.UserNotFoundException;
import devbootcamp.miniboss.demo.repository.UserRepository;
import devbootcamp.miniboss.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo = new UserRepository();

    public int createUser(User body) {
        return userRepo.insert(body);
    }
    public boolean checkExistingUser(Long id){
        try {
            userRepo.select(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            throw new UserNotFoundException();
        }
    }
}
