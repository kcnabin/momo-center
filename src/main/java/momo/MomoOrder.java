package momo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MomoOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;

    private String cardNumber;
    private String cardExpiration;
    private String cardCVV;

    private List<Momo> momos = new ArrayList<>();

    public void addMomo(Momo momo) {
        this.momos.add(momo);
    }
}
