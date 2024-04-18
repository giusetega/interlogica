package it.interlogica.pasticceria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="INGREDIENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Integer id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "size")
    private String size;

//    @ManyToMany(mappedBy = "containsIngredient")
//    Set<Sweets> usedBySweets;

}