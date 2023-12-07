package Wallet;

import static Key.KeyTransaction.keyTransaction;
import static Wallet.WalletStorage.walletStorage;
public class WalletSecurity {
    public static void walletSecurity(Wallet wallet,int input){
        switch (input){
            case 1:
                System.out.println("Your wallet is open");
                walletStorage(wallet);
                System.out.println("""
                    1 - Unlock your wallet
                    2 - Check your key holder
                    3 - Exit
                    """);
                System.out.print("Choose : ");
                break;
            case 2:
                System.out.println("You are checking your key holder");
                keyTransaction(wallet);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.print("Invalid input, please try again : ");
                break;
        }
    }
}
