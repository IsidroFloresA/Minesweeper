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
        publish();
    }
}
