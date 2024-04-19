package it.interlogica.pasticceria.controller;

import it.interlogica.pasticceria.dto.SweetDTO;
import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.service.SweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/backend/v1")
//@Log4j
@CrossOrigin
public class PasticceriaController {

    @Autowired
    private SweetsService sweetsService;

    @GetMapping("/")
    public List<SweetDTO> getSweets(){
        return sweetsService.getSweets();
    }

    @PostMapping
    public Sweets addSweets(@RequestBody Sweets sweets){
        return sweetsService.addSweets(sweets);
    }

    @PutMapping
    public Sweets updateSweets(@RequestBody Sweets sweets){
        return sweetsService.updateSweets(sweets);
    }

    @DeleteMapping
    public void deleteSweets(@RequestParam Integer id) throws Exception {
        sweetsService.deleteSweets(id);
    }

}
