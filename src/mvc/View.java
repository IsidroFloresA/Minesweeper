package mvc;

import javax.swing.*;

public class View extends JPanel implements Subscriber {
    public Model model;

    public View(Model m) {
        this.model = m;
        this.model.subscribe(this);
    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void update() {
        repaint();
    }
}
