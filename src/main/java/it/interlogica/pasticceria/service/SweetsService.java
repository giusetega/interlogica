package it.interlogica.pasticceria.service;

//import it.interlogica.pasticceria.repository.SweetsRepository;
import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.repository.SweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetsService {

    @Autowired
    private SweetsRepository sweetsRepository;

    public List<Sweets> getSweets(){
        return sweetsRepository.findAll();
    }
}
