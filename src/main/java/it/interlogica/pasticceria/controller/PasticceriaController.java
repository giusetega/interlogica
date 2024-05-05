package it.interlogica.pasticceria.controller;

import it.interlogica.pasticceria.dto.SweetDTO;
import it.interlogica.pasticceria.dto.SweetDetailDTO;
import it.interlogica.pasticceria.model.Ingredient;
import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.service.IngredientsService;
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

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping("/")
    public List<SweetDTO> getSweets(){
        return sweetsService.getSweets();
    }

    @GetMapping("/detail/{id}")
    public List<SweetDetailDTO> getSweetDetail(@PathVariable(name = "id", required = false) Integer id){
        return sweetsService.getSweetDetail(id);
    }

    @PostMapping(path = "/create")
    public Sweets addSweets(@RequestBody Sweets sweets){
        return sweetsService.addSweets(sweets);
    }

    @PostMapping(path = "/createForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Sweets addSweets( @RequestPart("image") MultipartFile image,
                             @RequestParam("name") String name,
                             @RequestParam("price") Float price,
                             @RequestParam("quantity") Integer quantity,
                             @RequestParam(value = "sugar", required = false) String sugar,
                             @RequestParam(value = "flour",required = false) String flour,
                             @RequestParam(value = "eggs", required = false) String eggs,
                             @RequestParam(value = "milk", required = false) String milk
    ) throws IOException {
        return sweetsService.addSweets(image, name, price, quantity, sugar, flour, eggs, milk);
    }

    @PutMapping("/update/{id}")
    public Sweets updateSweetsById(@PathVariable("id") Integer id, @RequestBody Sweets newSweet) throws Exception {
        return sweetsService.updateSweetsById(id, newSweet);
    }

    @DeleteMapping("/delete")
    public void deleteSweets(@RequestParam("id") Integer id) throws Exception {
        sweetsService.deleteSweets(id);
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients(){
        return  ingredientsService.getIngredients();
    }
}
