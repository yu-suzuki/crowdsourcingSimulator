package methods;

import elements.EvaluationResult;
import elements.Item;
import elements.Worker;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by ysuzuki on 2016/09/14.
 */
public class Assessment implements Callable {
    List<Worker> workers;
    List<Item> items;
    int method;

    public Assessment(List<Worker> workers, List<Item> items, int method) {
        this.workers = workers;
        this.items = items;
        this.method = method;
    }

    @Override
    public EvaluationResult call() throws Exception {


        return null;
    }
}
