using System;
using System.Collections.Generic;

class Program
{
    // Wallet dictionary
    static Dictionary<string, object> wallet = new Dictionary<string, object>{
        { "cardStorage", new List<string>() },
        { "idCardStorage", new List<string>() },
        { "moneyStorage", 0.0 },
        { "coinStorage", 0 },
        { "keyHolder", new List<string>() },
        { "isLocked", true }
    };

    static void UnlockWallet(){
        wallet["isLocked"] = false;
        Console.WriteLine("Wallet unlocked!");
    }

    static void AddCard(string card){
        if (!(bool)wallet["isLocked"]){
            ((List<string>)wallet["cardStorage"]).Add(card);
            Console.WriteLine($"Card added: {card}");
        } else{
            Console.WriteLine("Wallet is locked. Please unlock it first.");
        }
    }

    static void AddIdCard(string idCard){
        if (!(bool)wallet["isLocked"]){
            ((List<string>)wallet["idCardStorage"]).Add(idCard);
            Console.WriteLine($"ID Card added: {idCard}");
        } else{
            Console.WriteLine("Wallet is locked. Please unlock it first.");
        }
    }

    static void AddMoney(double amount){
        if (!(bool)wallet["isLocked"]){
            wallet["moneyStorage"] = (double)wallet["moneyStorage"] + amount;
            Console.WriteLine($"Added ${amount} to the wallet.");
        } else{
            Console.WriteLine("Wallet is locked. Please unlock it first.");
        }
    }

    static void AddCoins(int count){
        if (!(bool)wallet["isLocked"]){
            wallet["coinStorage"] = (int)wallet["coinStorage"] + count;
            Console.WriteLine($"Added {count} coins to the wallet.");
        } else{
            Console.WriteLine("Wallet is locked. Please unlock it first.");
        }
    }

    static void LockWallet(){
        wallet["isLocked"] = true;
        Console.WriteLine("Wallet locked!");
    }

    static void DisplayWalletStatus(){
        if (!(bool)wallet["isLocked"]){
        Console.WriteLine("--- Wallet Status ---");
        Console.WriteLine($"Card Storage: {string.Join(", ", (List<string>)wallet["cardStorage"])}");
        Console.WriteLine($"ID Card Storage: {string.Join(", ", (List<string>)wallet["idCardStorage"])}");
        Console.WriteLine($"Money Storage: ${(double)wallet["moneyStorage"]}");
        Console.WriteLine($"Coin Storage: {(int)wallet["coinStorage"]}");
        Console.WriteLine($"Is Locked: {(bool)wallet["isLocked"]}");
        Console.WriteLine("----------------------");
        } else{
            Console.WriteLine("Wallet is locked. Please unlock it first.");
        }
    }

    static void ProcessCommand(string command)
    {
        string[] commandParts = command.Split(' ');
        string action = commandParts[0].ToLower();
        string[] parameters = new string[commandParts.Length - 1];
        Array.Copy(commandParts, 1, parameters, 0, parameters.Length);

        switch (action)
        {
            case "unlock":
                UnlockWallet();
                break;
            case "addcard":
                AddCard(string.Join(" ", parameters));
                break;
            case "addidcard":
                AddIdCard(string.Join(" ", parameters));
                break;
            case "addmoney":
                double moneyAmount = 0.0;
                if (parameters.Length > 0)
                {
                    double.TryParse(parameters[0], out moneyAmount);
                }
                AddMoney(moneyAmount);
                break;
            case "addcoins":
                int coinCount = 0;
                if (parameters.Length > 0)
                {
                    int.TryParse(parameters[0], out coinCount);
                }
                AddCoins(coinCount);
                break;
            case "lock":
                LockWallet();
                break;
            case "status":
                DisplayWalletStatus();
                break;
            case "exit":
                Console.WriteLine("Exiting the wallet app. Goodbye!");
                Environment.Exit(0);
                break;
            default:
                Console.WriteLine("Invalid command. Please try again.");
                break;
        }
    }

    // Wallet app loop
    static void Main(){
        Console.WriteLine("--- Wallet App ---");
        Console.WriteLine("""
        These are the available commands :
            unlock
            addcard (cardname)
            addidcard (idcardname)
            addmoney (amount)
            addcoins (amount)
            lock
            status
            exit
        """);

        while (true){
            Console.Write("Enter a command: ");
            string userInput = Console.ReadLine();
            ProcessCommand(userInput);
        }
    }
}
