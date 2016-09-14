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
public class ItemGeneratorTest {
    List<Worker> workers;
    List<Item> items;
    ItemGenerator ig;

    @Before
    public void setUp() throws Exception {
        ig = new ItemGenerator(10, 10, 2);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void generateWorkers() throws Exception {
        workers = ig.generateWorkers();
        assertEquals(10, workers.size());
    }

    @Test
    public void generateItems() throws Exception {
        items = ig.generateItems();
        assertEquals(10, items.size());
    }

}