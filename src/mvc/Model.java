/**
 * Model.java
 *
 * @author Isidro Flores
 * @author Rustico De la Cruz
 * @author Ryan Nikopour
 *
 * Edits:
 *      Isidro 03/10/2025: Created File
 */

package mvc;

public class Model extends SimplePublisher {
    private Boolean unsavedChanges = false;
    private String fileName = null;

    public Boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUnsavedChanges(Boolean b) {
        this.unsavedChanges = b;
    }

    public void changed() {
        unsavedChanges = true;
        notify();
    }
}
