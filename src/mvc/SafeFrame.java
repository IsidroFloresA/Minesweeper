/**
 * SafeFrame.java
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
import java.awt.event.WindowEvent;

public class SafeFrame extends JFrame {

    protected void processWindowEvent(WindowEvent ev) {
        super.processWindowEvent(ev);
        if(ev.getID() == WindowEvent.WINDOW_CLOSING) {
            if (Utilities.confirm("Are you sure? Unsaved changes will be lost!")) {
                System.exit(0);
            }
        }
    }

    public SafeFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
