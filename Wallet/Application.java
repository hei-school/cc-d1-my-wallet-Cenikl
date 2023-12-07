import Card.CardObject;
import Id.IdentificationCard;
import Key.KeyObject;
import Wallet.Wallet;

import java.util.ArrayList;
import java.util.Scanner;

import static Wallet.WalletSecurity.walletSecurity;

public class Application {
    public static void main(String[] args) {
        Wallet wallet = new Wallet(
                new ArrayList<CardObject>(),
                0,
                new ArrayList<IdentificationCard>(),
                0,
                new ArrayList<KeyObject>());
        boolean applicationWorking = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
            ---Welcome to the wallet (edition Nikl) interface---
            
            The wallet is currently closed. Do you want to unlock it ?
            
            1 - Unlock your wallet
            2 - Check key holder
            2 - Exit
            """);
        System.out.print("Choose : ");
        while (applicationWorking){
            int input = scanner.nextInt();
            walletSecurity(wallet,input);
        }
    }
}
