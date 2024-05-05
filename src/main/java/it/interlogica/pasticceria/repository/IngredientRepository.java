package it.interlogica.pasticceria.repository;

import it.interlogica.pasticceria.model.Ingredient;
import it.interlogica.pasticceria.model.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
//    public List<Ingredient> findByIngredientName(List<String> ingredients);


    @Query("SELECT i FROM Ingredient i WHERE i.name IN (:ingredients)")
    List<Ingredient> findByIngredientName(@Param("ingredients") String... ingredients);
}
