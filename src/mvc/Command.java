/**
 * Command.java
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

public class Command {
    protected Model model;

    public Command(Model model) {
        this.model = model;
    }

    public void execute() {
    }
}
