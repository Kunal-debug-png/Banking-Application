package banking;

import java.util.ArrayList;
import java.util.List;

public class BankingSystem {
    private List<Account> accounts;

    public BankingSystem() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String ownerName, double initialBalance) {
        Account account = new Account(ownerName, initialBalance);
        accounts.add(account);
    }

    public double getAccountBalance(String ownerName) {
        for (Account account : accounts) {
            if (account.getOwnerName().equals(ownerName)) {
                return account.getBalance();
            }
        }
        System.out.println("Account not found.");
        return -1;
    }

    public void transfer(String senderName, String recipientName, double amount) {
        Account senderAccount = null;
        Account recipientAccount = null;

        for (Account account : accounts) {
            if (account.getOwnerName().equals(senderName)) {
                senderAccount = account;
            }
            if (account.getOwnerName().equals(recipientName)) {
                recipientAccount = account;
            }
        }

        if (senderAccount != null && recipientAccount != null) {
            if (senderAccount.getBalance() >= amount) {
                senderAccount.withdraw(amount);
                recipientAccount.deposit(amount);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient funds for the transfer.");
            }
        } else {
            System.out.println("Sender or recipient account not found.");
        }
    }
}
