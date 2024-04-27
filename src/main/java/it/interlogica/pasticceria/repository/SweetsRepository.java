package it.interlogica.pasticceria.repository;

import it.interlogica.pasticceria.dto.SweetDetailDTO;
import it.interlogica.pasticceria.model.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SweetsRepository extends JpaRepository<Sweets, Integer>{

//    @Query("SELECT new it.interlogica.pasticceria.dto.SweetDetailDTO(i.name) " +
//            "FROM Ingredient i " +
//            "JOIN ContainsSweetsIngredients c ON c.id  = i.id " +
//            "JOIN Sweets s ON s.id  = c.id " +
//            "WHERE s.id = :id ")
//    SweetDetailDTO getSweetDetailDto(@Param("id") Integer id);

    @Query(value = "SELECT i.name, i.quantity, i.size " +
            "FROM INGREDIENT i " +
            "JOIN CONTAINS_SWEETS_INGREDIENTS c ON c.INGREDIENT_ID  = i.INGREDIENT_ID " +
            "JOIN SWEETS s ON s.SWEETS_ID  = c.SWEETS_ID " +
            "WHERE s.SWEETS_ID = :id",
            nativeQuery = true
    )
    List<SweetDetailDTO> getSweetDetailDto(@Param("id") Integer id);

//    @Query(value = "SELECT new it.interlogica.pasticceria.dto.SweetDetailDTO(i.name) " +
//            "FROM INGREDIENT i " +
//            "WHERE i.id = :id",
//            nativeQuery = true
//    )
//    SweetDetailDTO getSweetDetailDto(@Param("id") Integer id);

//    @Query(value = "SELECT i.name FROM INGREDIENT i ",
//            nativeQuery = true
//    )
//    List<SweetDetailDTO> getSweetDetailDto();


}
