package methods;

import elements.Item;
import elements.Worker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ysuzuki on 2016/09/14.
 */
public class AssessmentTest {
    List<Item> items;
    List<Worker> workers;

    @Before
    public void setUp() throws Exception {
        items = new ArrayList<>(10);
        // 10 items and the answer is 0 or 1
        for(int i = 0; i < 10; i++) {
            items.add(new Item(i, i%2));
        }
        workers = new ArrayList<>(10);
        // 10 workers and the accuracy of workers are 0.1, 0.2, ..., 1.0
        for(int i = 0; i < 10; i++){
            workers.add(new Worker(i, (double) (i + 1) / 10));
        }
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void call() throws Exception {

    }

}