/**
 * View.java
 *
 * @author Jon Pearce
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro     03/10/2025: Created File
 *      All        03/15/2025: Edit the file
 *      Rustico    03/16/2025: Finished editing the file
 */
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
