package devbootcamp.mission2.demo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String menu;

    @Column
    private String extraTopping;

    @Column
    private boolean isFavorite;

}