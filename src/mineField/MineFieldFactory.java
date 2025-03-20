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
        return new String[] { "Move" };
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
