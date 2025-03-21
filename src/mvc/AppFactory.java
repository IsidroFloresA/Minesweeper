/**
 * AppFactory.java
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

public interface AppFactory {
    Model makeModel();

    View makeView(Model m);

    String[] getEditCommands();

    Command makeEditCommand(Model model, String type, Object source);

    String getTitle();

    String[] getHelp();

    String about();
}
