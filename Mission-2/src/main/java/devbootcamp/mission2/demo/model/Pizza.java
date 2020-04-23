package devbootcamp.mission2.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String flavour;

    @ElementCollection
    private List<String> extraTopping;

    @Column
    private boolean isFavorite;
}