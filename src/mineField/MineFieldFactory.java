/**
 * MineFliedFactory.java
 *
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro     03/10/2025: Created File
 *      All        03/14/2025: Edit the file
 *      Isidro    03/20/2025: Finished editing the file
 */
package mineField;

import mvc.*;

public class MineFieldFactory implements AppFactory {


    public Model makeModel() {
        return new MineField();
    }


    public View makeView(Model m) {
        return new MineFieldView((MineField) m);
    }

    public String[] getEditCommands() {
        return new String[] { "N", "NE", "NW", "S", "SE", "SW", "E", "W" };
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Move") {
            return new MoveCommand(model, (String) source);
        }
        return null;
    }

    public String getTitle() {
        return "Mine Field Simulator";
    }

    public String[] getHelp() {
        return new String[] {
                "Use the directional buttons to move the player across the minefield.",
                "Avoid stepping on mines and reach the bottom-right corner to win."
        };
    }

    public String about() {
        return "MineField Simulator. Copyright 2025 by SJSU";
    }
}
