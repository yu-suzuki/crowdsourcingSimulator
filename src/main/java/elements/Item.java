package elements;

/**
 * Created by ysuzuki on 2016/09/14.
 */
public class Item {
    int id, answer;
    public Item(int id, int answer) {
        this.id = id;
        this.answer = answer;
    }

    public int getID() {
        return id;
    }

    public int getAnswer() {
        return answer;
    }
}
