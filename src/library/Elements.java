package library;

import interfaces.library.IElements;

public class Elements implements IElements {
    private final String title;
    private final String path;

    public Elements(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }
}
