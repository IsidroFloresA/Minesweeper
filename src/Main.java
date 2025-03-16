import mvc.*;
import stopLight.*;

public class Main {
    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel stoplightPanel = new StoplightPanel(factory);
        stoplightPanel.display();
    }
}
