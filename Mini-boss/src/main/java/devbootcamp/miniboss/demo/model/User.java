package devbootcamp.miniboss.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
}
