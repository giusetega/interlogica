package it.interlogica.pasticceria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SweetsIngredientKey implements Serializable {

    @Column(name = "sweets_id")
    Integer sweetsId;

    @Column(name = "ingredient_id")
    Integer ingredientId;

}