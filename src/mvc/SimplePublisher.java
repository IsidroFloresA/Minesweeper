/**
 * SimplePublisher.java
 *
 * @author Jon Pearce
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Rustico     03/10/2025: Created File
 *      All        03/15/2025: Edit the file
 *      Rustico    03/16/2025: Finished editing the file
 */
package mvc;

import java.util.ArrayList;
import java.io.*;

public class SimplePublisher implements Publisher {
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
