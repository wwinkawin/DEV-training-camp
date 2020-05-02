package devbootcamp.miniboss.demo.model.catFacts;

import devbootcamp.miniboss.demo.exceptionhandling.CatServiceException;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Data
public class CatList {
    private List<Cat> all;

    public CatList() {
        all = new ArrayList<>();
    }

    public void sortCatList(String order) throws CatServiceException {
        if (order.equalsIgnoreCase("asc")) {
            Collections.sort(all);
        }

        else if (order.equalsIgnoreCase("desc")){
            Collections.sort(all);
            Collections.reverse(all);
        }

        else throw new CatServiceException();
    }
}
