package library;

import interfaces.library.IFilm;

import java.util.List;

public class Film extends Elements implements IFilm {
    private final String director;
    private final String duration;
    private final List<String> actors;


    public Film(String titre, String emplacement, String director, String duration, List<String> actors) {
        super(titre, emplacement);
        this.director = director;
        this.duration=duration;
        this.actors=actors;
    }

    public String getDirector() {
        return director;
    }

    public String getDuration() {
        return duration;
    }

    public List<String> getActors() {
        return actors;
    }
}
