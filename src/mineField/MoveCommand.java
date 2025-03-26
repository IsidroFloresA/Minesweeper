/**
 * MoveCommand.java
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

public class MoveCommand extends Command {
    private String heading;

    public MoveCommand(Model model, String heading) {
        super(model);
        this.heading = heading;
    }

    @Override
    public void execute() {
        try {
            MineField mineField = (MineField) model;
            mineField.movePlayer(heading);
            mineField.changed();
        } catch (Exception e) {
            Utilities.error(e.getMessage());
        }
    }
}
