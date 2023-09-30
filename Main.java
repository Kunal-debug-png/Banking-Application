import blockchain.*;
import banking.*;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        BankingSystem bankingSystem = new BankingSystem();


        bankingSystem.createAccount("Alice", 1000.0);
        bankingSystem.createAccount("Bob", 500.0);

        // Perform transactions
        bankingSystem.transfer("Alice", "Bob", 200.0);

        // Check account balances
        double aliceBalance = bankingSystem.getAccountBalance("Alice");
        double bobBalance = bankingSystem.getAccountBalance("Bob");

        // Print account balances
        System.out.println("Alice's Balance: " + aliceBalance);
        System.out.println("Bob's Balance: " + bobBalance);
    }
}
