package Card;

import Wallet.Wallet;

import java.util.Scanner;

public class CardTransaction {
    public static void cardTransaction(Wallet wallet){
        boolean isInCardStorage = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                You are in the Bank card storage
                1 - Check Card Slot 1
                2 - Check Card Slot 2
                3 - Check Card Slot 3
                4 - Check Card Slot 4
                5 - Put new Card
                6 - Retrieve a specific card
                7 - Exit
                """);
        System.out.print("Choose : ");
        while(isInCardStorage){
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    if(wallet.getCards().size() == 0){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    CardObject card0 = wallet.getCards().get(0);
                    System.out.println("You check the credit card \n"+
                            "Bank name : "+card0.getBankName()+
                            "\nCard Number : "+card0.getCardNumber()
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 2:
                    if(wallet.getCards().size() < 2){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    CardObject card1 = wallet.getCards().get(1);
                    System.out.println("You check the credit card \n"+
                            "Bank name : "+card1.getBankName()+
                            "\nCard Number : "+card1.getCardNumber()
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 3:
                    if(wallet.getCards().size() < 3){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    CardObject card2 = wallet.getCards().get(2);
                    System.out.println("You check the credit card \n"+
                            "Bank name : "+card2.getBankName()+
                            "\nCard Number : "+card2.getCardNumber()
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 4:
                    if(wallet.getCards().size() < 4){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    CardObject card3 = wallet.getCards().get(3);
                    System.out.println("You check the credit card \n"+
                            "Bank name : "+card3.getBankName()+
                            "\nCard Number : "+card3.getCardNumber()
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 5:
                    if(wallet.getCards().size() >= wallet.getCardMaxCapacity()){
                        System.out.println("There is no empty slot !");
                    } else {
                        System.out.print("Put your bank name here : ");
                        scanner.nextLine();
                        String bankName = scanner.nextLine();
                        wallet.getCards().add(new CardObject(bankName));
                        System.out.println("Created successfully !");
                    }
                    System.out.print("Choose one command again : ");
                    break;
                case 6:
                    System.out.print("""
                            Which card in the slot you want to retrieve ? 
                            1 or 2 or 3 or 4 (if they are not empty)
                            """);
                    int slot = scanner.nextInt();
                    if(slot == 1){
                        if(wallet.getCards().size() == 0){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getCards().remove(slot-1);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    } else if (slot == 2) {
                        if(wallet.getCards().size() < 2){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getCards().remove(slot-1);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    } else if (slot == 3) {
                        if(wallet.getCards().size() < 3){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getCards().remove(slot-1);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    } else if (slot == 4) {
                        if(wallet.getCards().size() < 4){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getCards().remove(slot-1);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                case 7:
                    isInCardStorage = false;
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
