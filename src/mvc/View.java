
/**
 * View.java
 *
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro 03/10/2025: Created File
 */
import javax.swing.JPanel;

package mvc;

public class View extends JPanel implements Subscriber {
    public Model model;

    public View(Model m) {
        this.model = m;
    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void update() {
        repaint();
    }
}
