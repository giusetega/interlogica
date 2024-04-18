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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "sweets_id")
    private Integer id;

    @Column(name = "sweets_name")
    private String sweetsName;

    @Column(name = "price")
    private Float price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_out_of_the_market", columnDefinition = "boolean default false")
    private Boolean isOutOfTheMarket;

    @Column(name = "is_first_day")
    private Boolean isFirstDay;

    @Column(columnDefinition = "integer default 100")
    private Integer valueFirstDay;

    @Column(name = "is_second_day")
    private Boolean isSecondDay;

    @Column(columnDefinition = "integer default 80")
    private Integer valueSecondDay;

    @Column(name = "is_third_day")
    private Boolean isThirdDay;

    @Column(columnDefinition = "integer default 20")
    private Integer valueThirdDay;

//    @Column(name = "is_more_than_three_days")
//    private Boolean isMoreThanThreeDays;

//    @ManyToMany
//    @JoinTable(
//            name = "contains",
//            joinColumns = @JoinColumn(name = "sweets_id"),
//            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
//    Set<Ingredient> containsIngredient;

}
