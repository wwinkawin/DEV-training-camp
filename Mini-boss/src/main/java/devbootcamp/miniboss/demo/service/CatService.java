package devbootcamp.miniboss.demo.service;

import devbootcamp.miniboss.demo.exceptionhandling.FavoriteCatNotFoundException;
import devbootcamp.miniboss.demo.repository.CatRepository;
import devbootcamp.miniboss.demo.exceptionhandling.CatServiceException;
import devbootcamp.miniboss.demo.model.catFacts.Cat;
import devbootcamp.miniboss.demo.model.catFacts.CatList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CatService {

    @Autowired
    CatRepository catRepo = new CatRepository();

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private CatList getExternalCat() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                "https://cat-fact.herokuapp.com/facts", CatList.class);
    }

    public List<Cat> getAll() throws CatServiceException {
        CatList catList = getExternalCat();
        catList.sortCatList("desc");
        return catList.getAll();
    }

    public void createCat(Long id, Cat body) throws CatServiceException {
        if (catRepo.insert(id,body) == 0) throw new CatServiceException();
    }

    public List<Cat> getAllFavorite(Long id) {
        List<Cat> catList = catRepo.selectAllFavorite(id);
        if (catList.isEmpty()){
            throw new FavoriteCatNotFoundException();
        }
            return catList;
    }

    public Cat getFavorite(Long id, Long cat_id) {
        try {
            return catRepo.selectFavorite(id, cat_id);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e.getMessage());
            throw  new FavoriteCatNotFoundException();
        }
    }

    public void deleteCat(Long id, Long cat_id) {
        if (catRepo.delete(id,cat_id) != 1){
            throw new FavoriteCatNotFoundException("There is no saved cat with id = " + cat_id + " for this user");
        };
    }
}