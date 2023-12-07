package Wallet;


import java.util.Scanner;

import static Card.CardTransaction.cardTransaction;
import static Coin.CoinTransaction.coinTransaction;
import static Id.IdCardTransaction.idCardTransaction;
import static Money.MoneyTransaction.moneyTransaction;

public class WalletStorage {
    public static void walletStorage(Wallet wallet){
        wallet.setClosed(false);
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do ?");
        System.out.println("""
                1 - Check Cards Storage
                2 - Check Coins Storage
                3 - Check IdCard Storage
                4 - Check Cash Storage
                5 - Close your wallet
                """);
        System.out.print("Choose : ");
        while(!wallet.isClosed()){
            int input = scanner.nextInt();
            switch(input){
                case 1:
                    System.out.println("You have "+wallet.getCards().size()+"/"+wallet.getCardMaxCapacity()+" cards in your wallet");
                    cardTransaction(wallet);
                    break;
                case 2:
                    System.out.println("You have a total of "+wallet.getCoins()+" coins worth of "+wallet.getCoins()+"$");
                    coinTransaction(wallet);
                    break;
                case 3:
                    System.out.println("You have "+wallet.getIdCards().size()+" cards in your wallet");
                    idCardTransaction(wallet);
                    break;
                case 4:
                    System.out.println("You have a total of "+wallet.getCoins()+" EUR in your wallet");
                    moneyTransaction(wallet);
                    break;
                case 5:
                    System.out.println("Your wallet is closed");
                    wallet.setClosed(true);
                    break;
                default:
                    System.out.print("Invalid input, please try again : ");
                    break;
            }
        }
    }
}
