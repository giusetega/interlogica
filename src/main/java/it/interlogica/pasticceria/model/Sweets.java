package it.interlogica.pasticceria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="SWEETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sweets {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "sweets_id")
    private Integer id;

    @Column(name = "sweets_name")
    private String sweetsName;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

//    @ManyToMany
//    @JoinTable(
//            name = "contains",
//            joinColumns = @JoinColumn(name = "sweets_id"),
//            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
//    Set<Ingredient> containsIngredient;

}
