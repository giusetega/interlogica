package it.interlogica.pasticceria.service;

//import it.interlogica.pasticceria.repository.SweetsRepository;
import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.repository.SweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SweetsService {

    @Autowired
    private SweetsRepository sweetsRepository;

    public List<Sweets> getSweets(){
        return sweetsRepository.findAll();
    }

    public Sweets addSweets(Sweets sweets){
        return sweetsRepository.save(sweets);
    }

    public Sweets updateSweets(Sweets sweets){
        return sweetsRepository.save(sweets);
    }

    public void deleteSweets(Integer id) throws Exception {
        Sweets sweets = sweetsRepository.findById(id).orElseThrow(() -> new Exception("The sweet with " + id + " does't exist"));
        sweets.setIsOutOfTheMarket(true);
        sweetsRepository.save(sweets);
//        sweetsRepository.deleteById(id);
    }

}
