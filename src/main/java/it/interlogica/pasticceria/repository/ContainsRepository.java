package it.interlogica.pasticceria.repository;

import it.interlogica.pasticceria.model.Contains;
import it.interlogica.pasticceria.model.Ingredient;
import it.interlogica.pasticceria.model.SweetsIngredientKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainsRepository extends JpaRepository<Contains, SweetsIngredientKey> {
}
