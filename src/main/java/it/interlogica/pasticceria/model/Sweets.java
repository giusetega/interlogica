package it.interlogica.pasticceria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SWEETS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sweets {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "sweets_id")
    private Integer id;

    @Column(name = "sweets_name")
    private String sweetsName;

    @Column(name = "price")
    private Float price;

}
