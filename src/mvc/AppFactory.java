/**
 * AppFactory.java
 *
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro 03/10/2025: Created File
 */

package mvc;

public interface AppFactory {
    void makeModel();

    void makeView(Model m);

    String getTitle();

    String getHelp();

    String about();

    String[] getEditCommands();

    void makeEditCommand(Model model, String type, Object source);
}
