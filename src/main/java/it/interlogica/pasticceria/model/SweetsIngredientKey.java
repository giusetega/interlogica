package it.interlogica.pasticceria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
class SweetsIngredientKey implements Serializable {

    @Column(name = "sweets_id")
    Long sweetsId;

    @Column(name = "ingredient_id")
    Long ingredientId;

}