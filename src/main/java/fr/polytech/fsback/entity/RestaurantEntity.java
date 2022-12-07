package fr.polytech.fsback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;

}
