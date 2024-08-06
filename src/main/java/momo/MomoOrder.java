package momo;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class MomoOrder {
    @NotBlank(message = "Name is required!")
    private String deliveryName;
    @NotBlank(message = "Street name is required!")
    private String deliveryStreet;
    @NotBlank(message = "City name is required!")
    private String deliveryCity;
    @NotBlank(message = "State name is required!")
    private String deliveryState;
    @NotBlank(message = "Zip Code is required!")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number!")
    private String cardNumber;
    @Pattern(regexp = "(0[1-9]|10|11|12)/20[0-9]{2}$", message = "Must be formatted in MM/YYYY")
    private String cardExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String cardCVV;

    @NotNull
    @Size(min = 1, message = "At least one momo order should be added!")
    private List<Momo> momos = new ArrayList<>();

    public void addMomo(Momo momo) {
        this.momos.add(momo);
    }
}
