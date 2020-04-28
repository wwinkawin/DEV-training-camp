package devbootcamp.mission3.demo.service;

import devbootcamp.mission3.demo.exceptionhandling.MandatoryIsNullException;
import devbootcamp.mission3.demo.exceptionhandling.PizzaNotFoundException;
import devbootcamp.mission3.demo.exceptionhandling.PizzaServiceException;
import devbootcamp.mission3.demo.repository.PizzaRepository;
import devbootcamp.mission3.demo.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    PizzaRepository repo = new PizzaRepository();

    public List<Pizza> retrievePizza() {
        return repo.selectAll();
    }

    public Pizza retrievePizza(Long id) {
        try{
        return repo.select(id);}
        catch (EmptyResultDataAccessException e){
            throw new PizzaNotFoundException();
        }
    }

    public int createPizza(Pizza pizza) throws PizzaServiceException {
        try {
            return repo.insert(pizza);
        } catch (DataAccessException e) {
            if (e.getMessage().contains("SQLIntegrityConstraintViolationException")) {
                throw new MandatoryIsNullException("Mandatory field is null");
            } else throw new PizzaServiceException();
        }

    }

    public int updatePizza(Long id, Pizza pizza) throws PizzaServiceException {
        try {
            int rowNo = repo.update(id, pizza);
            if (rowNo == 0) {
                throw new PizzaNotFoundException();
            }
            return rowNo;
        } catch (DataAccessException e) {
            if (e.getMessage().contains("SQLIntegrityConstraintViolationException")) {
                throw new MandatoryIsNullException("Mandatory field is null");
            } else throw new PizzaServiceException();
        }
    }

    public int deletePizza(Long id) {
        int rowNo = repo.delete(id);
        if (rowNo == 0) {
            throw new PizzaNotFoundException("There is no corresponding pizza in database");
        }
        return rowNo;
    }
}
