package library;

import interfaces.library.IElements;

public class Elements implements IElements {
    private final String titre;
    private final String emplacement;

    public Elements(String titre, String emplacement) {
        this.titre = titre;
        this.emplacement = emplacement;
    }

    public String getTitre() {
        return titre;
    }

    public String getEmplacement() {
        return emplacement;
    }
}
