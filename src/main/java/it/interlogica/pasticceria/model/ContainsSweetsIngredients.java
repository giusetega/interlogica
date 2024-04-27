package it.interlogica.pasticceria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CONTAINS_SWEETS_INGREDIENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContainsSweetsIngredients {

    @EmbeddedId
    private SweetsIngredientKey id;

    @ManyToOne
    @MapsId("sweetsId")
    @JoinColumn(name = "sweets_id")
    private Sweets sweetsId;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredientId;

//    @Column(name = "available_quantity")
//    private Integer availableQuantity;
}