package Card;

import java.util.UUID;

public class CardObject{
    private String bankName;
    private Integer capacityTaken;
    private String cardNumber;

    public CardObject(String bankName) {
        this.bankName = bankName;
        this.capacityTaken = 1;
        this.cardNumber = String.valueOf(UUID.randomUUID());
    }

}