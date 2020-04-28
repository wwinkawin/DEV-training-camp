package devbootcamp.mission3.demo.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import java.util.List;

@Data
public class Pizza {
    private Long id;
    private String flavour;
    private List<String> extraTopping;
    private boolean isFavorite;
}