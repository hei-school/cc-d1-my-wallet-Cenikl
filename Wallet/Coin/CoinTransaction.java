package Coin;

import Wallet.Wallet;

import java.util.Scanner;

public class CoinTransaction {
    public static void coinTransaction(Wallet wallet){
        boolean isInCoinStorage = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                You are in the coins storage
                1 - Check Coins
                2 - Put some coins
                3 - Retrieve some coins
                4 - Take all coins
                5 - Exit
                """);
        System.out.print("Choose : ");
        while(isInCoinStorage){
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    System.out.println("You have a total of "+wallet.getCoins()+"/"+wallet.getCoinMaxCapacity()+" coins");
                    System.out.print("Choose one command : ");
                    break;
                case 2:
                    System.out.print("How much coins do you want to add ? : ");
                    int values = scanner.nextInt();
                    if((wallet.getCoins() + values) > wallet.getCoinMaxCapacity()){
                        System.out.println("You are adding too much coins ! "+wallet.getCoinMaxCapacity()+" is the maximum");
                        System.out.print("Choose one command : ");
                        break;
                    }
                    wallet.addCoins(values);
                    System.out.println("Storing successful !");
                    System.out.print("Choose one command : ");
                    break;
                case 3:
                    System.out.print("How much coins do you want to retrieve ? : ");
                    int value = scanner.nextInt();
                    if(wallet.getCoins() == 0 || (wallet.getCoins() - value) < 0 ){
                        System.out.println("You are retrieving too much coins ! ,0 is the minimum");
                        System.out.print("Choose one command : ");
                        break;
                    }
                    wallet.removeCoins(value);
                    System.out.println("Retrieving successful !");
                    System.out.print("Choose one command : ");
                    break;
                case 4:
                    if(wallet.getCoins() > 0){
                        wallet.removeCoins(wallet.getCoins());
                        System.out.println("You took all the coins in the wallet");
                    } else{
                        System.out.println("There is no more coin inside !");
                    }
                    System.out.print("Choose one command again : ");
                    break;
                case 5:
                    isInCoinStorage = false;
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
