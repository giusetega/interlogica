package it.interlogica.pasticceria.repository;

import it.interlogica.pasticceria.model.Ingredient;
import it.interlogica.pasticceria.model.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
