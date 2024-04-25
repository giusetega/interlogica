package it.interlogica.pasticceria.service;

//import it.interlogica.pasticceria.repository.SweetsRepository;

import it.interlogica.pasticceria.dto.SweetDTO;
import it.interlogica.pasticceria.model.Sweets;
import it.interlogica.pasticceria.repository.SweetsRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@Slf4j
public class SweetsService {

    @Autowired
    private SweetsRepository sweetsRepository;

    public List<SweetDTO> getSweets() {
        return sweetsRepository.findAll().stream().filter(sweet -> filterSweet(sweet)).map(sweet -> mapSweet(sweet)).toList();
    }

    public static boolean filterSweet(Sweets sweet) {
        float totalPrice = 0;
        if(sweet.getIsOutOfTheMarket()){
            return false;
        }else if (sweet.getIsFirstDay()!= null && sweet.getIsFirstDay() && sweet.getValueFirstDay() != null ) {
            return true;
        } else if (sweet.getIsSecondDay()!= null && sweet.getIsSecondDay() && sweet.getValueSecondDay() != null ) {
            return true;
        } else if (sweet.getIsThirdDay()!= null &&  sweet.getIsThirdDay()  && sweet.getValueThirdDay() != null) {
            return true;
        } else {
            // isMoreThanThreeDays
            return false;

        }
    }

    public static SweetDTO mapSweet(Sweets sweet) {
        float totalPrice = 0;
        if (sweet.getIsFirstDay()!= null && sweet.getIsFirstDay() && sweet.getValueFirstDay() != null ) {
            totalPrice = sweet.getPrice() * sweet.getValueFirstDay() / 100;
        } else if (sweet.getIsSecondDay()!= null && sweet.getIsSecondDay() && sweet.getValueSecondDay() != null ) {
            totalPrice = sweet.getPrice() * sweet.getValueSecondDay() / 100;
        } else if (sweet.getIsThirdDay()!= null &&  sweet.getIsThirdDay()  && sweet.getValueThirdDay() != null) {
            totalPrice = sweet.getPrice() * sweet.getValueThirdDay() / 100;
        } else {
            // isMoreThanThreeDays
            return null;

        }
        return new SweetDTO(sweet.getId(), sweet.getName(), sweet.getPrice(), sweet.getQuantity(), totalPrice, sweet.getImage());
    }


    public Sweets addSweets(Sweets sweets) {
        sweets.setIsOutOfTheMarket(false);
        sweets.setIsFirstDay(true);
        sweets.setValueFirstDay(100);
        sweets.setValueSecondDay(80);
        sweets.setValueThirdDay(20);
        return sweetsRepository.save(sweets);
    }

    public Sweets addSweets(MultipartFile multipartFile, String name, Float price, Integer quantity) throws IOException {
        File targetFile;
        if(multipartFile != null){
            log.debug("Start file saving");

            InputStream fileStream = multipartFile.getInputStream();
            targetFile = new File("/tmp/" + multipartFile.getOriginalFilename());
            Files.copy(fileStream, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            IOUtils.closeQuietly(fileStream);
        }

        Sweets sweets = new Sweets();
        sweets.setIsOutOfTheMarket(false);
        sweets.setIsFirstDay(true);
        sweets.setValueFirstDay(100);
        sweets.setValueSecondDay(80);
        sweets.setValueThirdDay(20);
        sweets.setImage(multipartFile != null ? multipartFile.getOriginalFilename() : null);
        sweets.setName(name);
        sweets.setPrice(price);
        sweets.setQuantity(quantity);
        return sweetsRepository.save(sweets);
    }

    public Sweets updateSweetsById(Integer id, Sweets newSweet) throws Exception {
        return sweetsRepository.findById(id)
                .map(sweet -> {
                    sweet.setName(!newSweet.getName().isEmpty() ? newSweet.getName() : sweet.getName());
                    sweet.setPrice(newSweet.getPrice() != null ? newSweet.getPrice() : sweet.getPrice());
                    sweet.setQuantity(newSweet.getQuantity() != null ? newSweet.getQuantity() : sweet.getQuantity());
                    return sweetsRepository.save(sweet);
                })
                .orElseGet(() -> {
                    return sweetsRepository.save(newSweet);
                });
    }

    public void deleteSweets(Integer id) throws Exception {
        Sweets sweets = sweetsRepository.findById(id).orElseThrow(() -> new Exception("The sweet with " + id + " does't exist"));
        sweets.setIsOutOfTheMarket(true);
        sweetsRepository.save(sweets);
//        sweetsRepository.deleteById(id);
    }

}
