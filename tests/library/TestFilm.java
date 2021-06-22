package library;

import interfaces.library.IFilm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Factory;

import java.util.ArrayList;
import java.util.List;

public class TestFilm {

    @Test
    public void TestFilmCreation(){
        List<String> acteurs = new ArrayList<>();
        Factory factory = Factory.getFact();
        IFilm film = factory.newFilm("Bonjour", "c:/bonjour.mp4", "Spielberg", "1:01", acteurs);

        Assertions.assertEquals(film.getTitre(), "Bonjour");
        Assertions.assertEquals(film.getEmplacement(), "c:/bonjour.mp4");
        Assertions.assertEquals(film.getRealisateur(), "Spielberg");
        Assertions.assertEquals(film.getDuree(), "1:01");
        Assertions.assertEquals(film.getActeurs().size(), 0);
    }

}
