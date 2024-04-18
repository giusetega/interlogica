package it.interlogica.pasticceria.service;

//import it.interlogica.pasticceria.repository.SweetsRepository;

import it.interlogica.pasticceria.dto.SweetDTO;
import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.repository.SweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SweetsService {

    @Autowired
    private SweetsRepository sweetsRepository;

    public List<SweetDTO> getSweets() {
        return sweetsRepository.findAll().stream().map(SweetsService::test).toList();
    }

    public static SweetDTO test(Sweets sweet) {
        float totalPrice = 0;
        if (sweet.getIsFirstDay()) {
            totalPrice = sweet.getPrice() * sweet.getValueFirstDay() / 100;
        } else if (sweet.getIsSecondDay()) {
            totalPrice = sweet.getPrice() * sweet.getValueSecondDay() / 100;
        } else if (sweet.getIsThirdDay()) {
            totalPrice = sweet.getPrice() * sweet.getValueThirdDay() / 100;
        } else {
            // isMoreThanThreeDays
            return null;

        }
        return new SweetDTO(sweet.getId(), sweet.getSweetsName(), sweet.getPrice(), sweet.getQuantity(), totalPrice);
    }

//    private Integer id;
//    private String name;
//    private Float price;
//    private Integer quantity;
//    private Float totalPrice;

    public Sweets addSweets(Sweets sweets) {
        sweets.setIsOutOfTheMarket(false);
        sweets.setIsFirstDay(true);
        return sweetsRepository.save(sweets);
    }

    public Sweets updateSweets(Sweets sweets) {
        return sweetsRepository.save(sweets);
    }

    public void deleteSweets(Integer id) throws Exception {
        Sweets sweets = sweetsRepository.findById(id).orElseThrow(() -> new Exception("The sweet with " + id + " does't exist"));
        sweets.setIsOutOfTheMarket(true);
        sweetsRepository.save(sweets);
//        sweetsRepository.deleteById(id);
    }

}
