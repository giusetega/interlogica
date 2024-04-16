package it.interlogica.pasticceria.controller;

import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.service.SweetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/backend/v1")
//@Log4j
public class PasticceriaController {

    @Autowired
    private SweetsService sweetsService;

    @GetMapping("/")
    public List<Sweets> getSweets(){
        return sweetsService.getSweets();
    }
}
