import elements.EvaluationResult;
import elements.Item;
import elements.Worker;
import methods.Assessment;
import methods.ItemGenerator;
import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ysuzuki on 2016/09/14.
 */
public class Main {
    static int workerNum, itemNum, threadSize, optionNum, method, iteration;

    public static void main(String[] args) {
        // Option Settings
        Options options = new Options();
        options.addOption("w", "worker", true, "worker number");
        options.addOption("i", "item", true, "item number");
        options.addOption("t", "thread", true, "thread number");
        options.addOption("o", "option", true, "item option");
        options.addOption("m", "method", true, "evaluation method");
        options.addOption("c", "iteration", true, "iteration");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("worker")){
                workerNum = Integer.parseInt(cmd.getOptionValue("worker"));
            } else {
                workerNum = 10;
            }
            if(cmd.hasOption("item")){
                itemNum = Integer.parseInt(cmd.getOptionValue("item"));
            } else {
                itemNum = 10;
            }
            if(cmd.hasOption("thread")){
                threadSize = Integer.parseInt(cmd.getOptionValue("thread"));
            } else {
                threadSize = 1;
            }
            if(cmd.hasOption("option")){
                optionNum = Integer.parseInt(cmd.getOptionValue("option"));
            } else {
                optionNum = 2;
            }
            if(cmd.hasOption("method")){
                method = Integer.parseInt(cmd.getOptionValue("method"));
            } else {
                method = 2;
            }
            if(cmd.hasOption("iteration")){
                iteration = Integer.parseInt(cmd.getOptionValue("iteration"));
            } else {
                iteration = 2;
            }
        } catch (ParseException e) {
            System.err.println( "Unexpected exception:" + e.getMessage() );
        }

        // Generate Items
        ItemGenerator ig = new ItemGenerator(workerNum, itemNum, optionNum);

        // Processor
        ExecutorService executor = Executors.newFixedThreadPool(threadSize);
        List<Future<EvaluationResult>> futures = new ArrayList<>();
        for(int i = 0; i < iteration; i++){
            List<Worker> workers = ig.generateWorkers();
            List<Item> items = ig.generateItems();
            Assessment assessment = new Assessment(workers, items, method);
        }
    }
}
