package mvc;

public interface Publisher {
    void subscribe(Subscriber s);

    void unsubscribe(Subscriber s);

    void notify();
}
