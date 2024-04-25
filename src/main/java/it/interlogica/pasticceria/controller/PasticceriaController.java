package it.interlogica.pasticceria.controller;

import it.interlogica.pasticceria.dto.SweetDTO;
import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.service.SweetsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/backend/v1")
@Slf4j
public class PasticceriaController {

    @Autowired
    private SweetsService sweetsService;

    @GetMapping("/")
    public List<SweetDTO> getSweets(){
        return sweetsService.getSweets();
    }

    @PostMapping(path = "/create")
    public Sweets addSweets(@RequestBody Sweets sweets){
        return sweetsService.addSweets(sweets);
    }

    @PostMapping(path = "/createForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Sweets addSweets( @RequestPart("image") MultipartFile image,
                             @RequestParam("name") String name,
                             @RequestParam("price") Float price,
                             @RequestParam("quantity") Integer quantity) throws IOException {
        return sweetsService.addSweets(image, name, price, quantity);
    }

    @PutMapping("/update/{id}")
    public Sweets updateSweetsById(@PathVariable("id") Integer id, @RequestBody Sweets newSweet) throws Exception {
        return sweetsService.updateSweetsById(id, newSweet);
    }

    @DeleteMapping("/delete")
    public void deleteSweets(@RequestParam("id") Integer id) throws Exception {
        sweetsService.deleteSweets(id);
    }

}
