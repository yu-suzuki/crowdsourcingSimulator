package methods;

import elements.Item;
import elements.Worker;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysuzuki on 2016/09/14.
 */
public class ItemGenerator {
    private int workerNum, itemNum, optionNum;
    public ItemGenerator(int workerNum, int itemNum, int optionNum) {
        this.workerNum = workerNum;
        this.itemNum = itemNum;
        this.optionNum = optionNum;
    }

    public List<Worker> generateWorkers() {
        List<Worker> workers = new ArrayList<>(workerNum);
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            for (int i = 0; i < workerNum; i++) {
                workers.add(new Worker(i, number.nextDouble() /2 + 0.5));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<Item> generateItems() {
        List<Item> items = new ArrayList<>(itemNum);
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            for(int i = 0; i < itemNum; i++){
                items.add(new Item(i, number.nextInt(optionNum)));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return items;
    }
}
