import mvc.*;
import mineField.*;

public class Main {
    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        AppPanel panel = new MineFieldAppPanel(factory);
        panel.display();
    }
}
