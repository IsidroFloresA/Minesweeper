/**
 * MineFieldAppPanel.java
 *
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro     03/10/2025: Created File
 *      All        03/14/2025: Edit the file
 *      Isidro     03/20/2025: Finished editing the file
 */
package mineField;

import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MineFieldAppPanel extends AppPanel {
    private JButton[] moveButtons;
    private String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    public MineFieldAppPanel(AppFactory factory) {
        super(factory);

        JPanel movePanel = new JPanel();
        movePanel.setLayout(new GridLayout(3, 3));

        moveButtons = new JButton[8];
        for (int i = 0; i < directions.length; i++) {
            moveButtons[i] = new JButton(directions[i]);
            moveButtons[i].addActionListener(this);
            movePanel.add(moveButtons[i]);
        }

        controlPanel.add(movePanel);
    }


    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        try {
            if (java.util.Arrays.asList(directions).contains(command)) {
                Command moveCommand = factory.makeEditCommand(model, "Move", command);
                moveCommand.execute();
            } else {
                super.actionPerformed(ae);
            }
        } catch (Exception e) {
            Utilities.error(e);
        }
    }

    public static void main(String[] args) {
        AppFactory factory = new MineFieldFactory();
        MineFieldAppPanel panel = new MineFieldAppPanel(factory);
        panel.display();
    }
}
