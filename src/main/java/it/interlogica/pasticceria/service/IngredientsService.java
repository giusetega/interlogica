package it.interlogica.pasticceria.service;

import it.interlogica.pasticceria.model.Ingredient;
import it.interlogica.pasticceria.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IngredientsService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }
}
