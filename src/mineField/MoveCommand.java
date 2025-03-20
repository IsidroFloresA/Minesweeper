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
