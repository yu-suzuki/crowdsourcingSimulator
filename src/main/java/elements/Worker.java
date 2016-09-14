package elements;

/**
 * Created by ysuzuki on 2016/09/14.
 */
public class Worker {
    private int id;
    private double accuracy;
    public Worker(int id, double accuracy) {
        this.id = id;
        this.accuracy = accuracy;
    }

    public int getID() {
        return id;
    }

    public double getAccuracy() {
        return accuracy;
    }
}
