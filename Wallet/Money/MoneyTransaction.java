package Money;

import Wallet.Wallet;

import java.util.Scanner;

public class MoneyTransaction {
    public static void moneyTransaction(Wallet wallet){
        boolean isInMoneyStorage = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                You are in the money storage
                1 - Check Money
                2 - Put some money
                3 - Retrieve some money
                4 - Take all money
                5 - Exit
                """);
        System.out.print("Choose : ");
        while(isInMoneyStorage){
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    System.out.println("You have a total of "+wallet.getCash()+"/"+wallet.getMoneyMaxCapacity()+" cash");
                    System.out.print("Choose one command : ");
                    break;
                case 2:
                    System.out.print("How much money do you want to add ? : ");
                    int values = scanner.nextInt();
                    if((wallet.getCash() + values) > wallet.getMoneyMaxCapacity()){
                        System.out.println("You are adding too much money ! "+wallet.getMoneyMaxCapacity()+" is the maximum");
                        System.out.print("Choose one command : ");
                        break;
                    }
                    wallet.addCash(values);
                    System.out.println("Storing successful !");
                    System.out.print("Choose one command : ");
                    break;
                case 3:
                    System.out.print("How much money do you want to retrieve ? : ");
                    int value = scanner.nextInt();
                    if(wallet.getCash() == 0 || (wallet.getCash() - value) < 0 ){
                        System.out.println("You are retrieving too much money ! 0 is the minimum");
                        System.out.print("Choose one command : ");
                        break;
                    }
                    wallet.removeCash(value);
                    System.out.println("Retrieving successful !");
                    System.out.print("Choose one command : ");
                    break;
                case 4:
                    if(wallet.getCash() > 0){
                        wallet.removeCash(wallet.getCash());
                        System.out.println("You took all the money in the wallet");
                    } else{
                        System.out.println("There is no more money inside !");
                    }
                    System.out.print("Choose one command again : ");
                    break;
                case 5:
                    isInMoneyStorage = false;
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

