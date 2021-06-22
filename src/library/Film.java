package library;

import interfaces.library.IFilm;

import java.util.List;

public class Film extends Elements implements IFilm {
    private final String realisateur;
    private final String duree;
    private final List<String> acteurs;


    public Film(String titre, String emplacement, String realisateur, String duree, List<String> acteurs) {
        super(titre, emplacement);
        this.realisateur = realisateur;
        this.duree=duree;
        this.acteurs=acteurs;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public String getDuree() {
        return duree;
    }

    public List<String> getActeurs() {
        return acteurs;
    }
}
