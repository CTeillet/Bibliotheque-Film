package bibliotheque;

import interfaces.bibliotheque.IElements;

public class Elements implements IElements {
    private String titre;
    private String emplacement;

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
