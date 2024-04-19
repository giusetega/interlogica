package it.interlogica.pasticceria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SweetDTO {
    private Integer id;
    private String name;
    private Float price;
    private Integer quantity;
    private Float totalPrice;
    private String image;
}
