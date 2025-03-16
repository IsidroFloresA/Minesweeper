package mvc;

import java.util.ArrayList;
import java.io.*;

public class SimplePublisher implements Publisher, Serializable {
    private ArrayList<Subscriber> subscribers;

    public SimplePublisher() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void publish() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        subscribers = new ArrayList<>();
    }
}
