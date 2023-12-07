package Id;

import Card.CardObject;
import Wallet.Wallet;

import java.util.Scanner;

public class IdCardTransaction {
    public static void idCardTransaction(Wallet wallet){
        boolean isinIDCardStorage = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                You are in the Bank card storage
                1 - Check IDCard Slot 1
                2 - Check IDCard Slot 2
                3 - Check IDCard Slot 3
                4 - Put new Identification Card
                5 - Retrieve a specific card
                6 - Exit
                """);
        System.out.print("Choose : ");
        while(isinIDCardStorage){
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    if(wallet.getIdCards().size() == 0){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    IdentificationCard card0 = wallet.getIdCards().get(0);
                    System.out.println("You check the ID card \n"+
                            "First name : "+card0.getFirstName()+
                            "\nLast name : "+card0.getLastName()+
                            "\nAge : "+card0.getAge()+
                            "\nID Card Number : "+card0.getIdCard()
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 2:
                    if(wallet.getIdCards().size() < 2){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    IdentificationCard card1 = wallet.getIdCards().get(1);
                    System.out.println("You check the ID card \n"+
                            "First name : "+card1.getFirstName()+
                            "\nLast name : "+card1.getLastName()+
                            "\nAge : "+card1.getAge()+
                            "\nID Card Number : "+card1.getIdCard()
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 3:
                    if(wallet.getIdCards().size() < 3){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    IdentificationCard card2 = wallet.getIdCards().get(2);
                    System.out.println("You check the ID card \n"+
                            "First name : "+card2.getFirstName()+
                            "\nLast name : "+card2.getLastName()+
                            "\nAge : "+card2.getAge()+
                            "\nID Card Number : "+card2.getIdCard()
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 4:
                    if(wallet.getIdCards().size() >= wallet.getIdCardMaxCapacity()){
                        System.out.println("There is no empty slot !");
                    } else {
                        System.out.print("Put the first name here : ");
                        String firstName = scanner.next();
                        System.out.print("Put the last name here : ");
                        String lastName = scanner.next();
                        System.out.print("Put the age here : ");
                        Integer age = scanner.nextInt();
                        wallet.getIdCards().add(new IdentificationCard(firstName,lastName,age));
                        System.out.println("Created successfully !");
                    }
                    System.out.print("Choose one command again : ");
                    break;
                case 5:
                    System.out.print("""
                            Which ID card in the slot you want to retrieve ? 
                            1 or 2 or 3 (if they are not empty)
                            """);
                    int slot = scanner.nextInt();
                    if(slot == 1){
                        if(wallet.getIdCards().size() == 0){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getIdCards().remove(slot-1);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    } else if (slot == 2) {
                        if(wallet.getIdCards().size() < 2){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getIdCards().remove(slot-1);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    } else if (slot == 3) {
                        if(wallet.getIdCards().size() < 3){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getIdCards().remove(slot-1);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                case 6:
                    isinIDCardStorage = false;
                    System.out.println("What would you like to do ?");
                    System.out.println("""
                        1 - Check Cards Storage
                        2 - Check Coins Storage
                        3 - Check IdCard Storage
                        4 - Check Cash Storage
                        5 - Check Paper Storage
                        6 - Close your wallet
                        """);
                    System.out.print("Choose : ");
                    break;
                default:
                    System.out.print("Invalid input, please try again : ");
                    break;
            }
        }
    }
}
