
/**
 * Publisher.java
 *
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro 03/10/2025: Created File
 */
import java.util.ArrayList;
import java.io.*;

package mvc;

public class simplePublisher implements Publisher, Serializable {
    private ArrayList<Subscriber> subscribers;

    public simplePublisher() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void notify() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        subscribers = new ArrayList<>();
    }
}
