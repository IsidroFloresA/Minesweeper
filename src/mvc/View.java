package mvc;

import javax.swing.JPanel;

public class View extends JPanel implements Subscriber {
    public Model model;

    public View(Model m) {
        this.model = m;
    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void update() {
        this.repaint();
    }
}
