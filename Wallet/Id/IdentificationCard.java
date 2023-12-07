package Id;

import java.util.UUID;

public class IdentificationCard {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String idCard;

    public IdentificationCard(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.idCard = UUID.randomUUID().toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getIdCard() {
        return idCard;
    }

    public Integer getCapacityTaken() {
        return 1;
    }
}
