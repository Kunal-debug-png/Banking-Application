package blockchain;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Block {
    private String previousHash;
    private List<String> transactions;
    private String hash;

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.transactions = new ArrayList<>();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        try {
            String dataToHash = previousHash + transactions.toString();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(dataToHash.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
        hash = calculateHash();
    }
}
