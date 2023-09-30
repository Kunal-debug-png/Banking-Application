package blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();

        chain.add(new Block("0"));  // genesis block
    }

    public void addBlock(String transaction) {
        Block previousBlock = chain.get(chain.size() - 1);
        Block newBlock = new Block(previousBlock.getHash());
        newBlock.addTransaction(transaction);
        chain.add(newBlock);
    }
}
