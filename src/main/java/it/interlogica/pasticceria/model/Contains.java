package it.interlogica.pasticceria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CONTAINS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Contains {

    @EmbeddedId
    private SweetsIngredientKey id;

    @ManyToOne
    @MapsId("sweetsId")
    @JoinColumn(name = "sweets_id")
    private Sweets sweets;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "available_quantity")
    private Integer availableQuantity;
}