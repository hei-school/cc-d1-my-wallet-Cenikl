package Card;

import java.util.UUID;

public class CardObject{
    private final String bankName;
    private final String cardNumber;

    public CardObject(String bankName) {
        this.bankName = bankName;
        this.cardNumber = UUID.randomUUID().toString();
    }

    public String getBankName() {
        return bankName;
    }
    public String getCardNumber(){
        return cardNumber;
    }

    public Integer getCapacityTaken() {
        return 1;
    }
}