package it.interlogica.pasticceria.repository;

import it.interlogica.pasticceria.model.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SweetsRepository extends JpaRepository<Sweets, Integer>{
}
