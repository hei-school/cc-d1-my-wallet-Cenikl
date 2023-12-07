package Key;

import Wallet.Wallet;

import java.util.Scanner;

public class KeyTransaction {
    public static void keyTransaction(Wallet wallet){
        boolean isInKeyHolder = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                You are in the Key holder storage
                1 - Check your key
                2 - Put new key
                3 - Retrieve the key
                4 - Exit
                """);
        System.out.print("Choose : ");
        while(isInKeyHolder){
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    if(wallet.getKeys().size() == 0){
                        System.out.println("Empty slot");
                        System.out.print("Choose one command again : ");
                        break;
                    }
                    KeyObject key = wallet.getKeys().get(0);
                    System.out.println("You check the key \n"+
                            "It is your "+key.getName()+" key"
                    );
                    System.out.print("Choose one command again : ");
                    break;
                case 2:
                    if(wallet.getKeys().size() == 1){
                        System.out.println("There is no empty slot !");
                    } else {
                        System.out.print("Put the name of the key here : ");
                        scanner.nextLine();
                        String keyName = scanner.nextLine();
                        wallet.getKeys().add(new KeyObject(keyName));
                        System.out.println("You put your key in in the key holder");
                    }
                    System.out.print("Choose one command again : ");
                    break;
                case 3:
                    System.out.print("""
                            Do you want to retrieve your key ? 
                            
                            1 - Yes
                            2 - No
                            """);
                    System.out.print("Choose : ");
                    int answer = scanner.nextInt();
                    if(answer == 1){
                        if(wallet.getKeys().size() == 0){
                            System.out.println("Empty slot");
                            System.out.print("Choose one command again : ");
                            break;
                        }
                        wallet.getKeys().remove(0);
                        System.out.println("Removed successfully");
                        System.out.print("Choose one command again : ");
                        break;
                    } else if (answer == 2) {
                        System.out.println("Removed successfully");
                        System.out.println("""
                            You are in the Key holder storage
                            1 - Check your key
                            2 - Put new key
                            3 - Retrieve the key
                            4 - Exit
                            """);
                        break;
                    }
                case 4:
                    isInKeyHolder = false;
                    System.out.println("What would you like to do ?");
                    System.out.println("""
                        1 - Unlock your wallet
                        2 - Check your key holder
                        3 - Exit
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
