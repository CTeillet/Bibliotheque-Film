package library;

import interfaces.library.ILibrary;
import interfaces.library.IElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Factory;

public class TestLibrary {
    private ILibrary bibliotheque;
    private final Factory factory = Factory.getFact();

    @BeforeEach
    private void initialize(){
        bibliotheque = factory.newBibliotheque();
    }

    @Test
    public void TestAjout(){
        IElements el = factory.newElements("Bonjour", "c:/Bonjour.mp4");
        bibliotheque.add(el);
        Assertions.assertEquals(bibliotheque.size(), 1);
    }

    @Test
    public void TestClear(){
        IElements el = factory.newElements("Bonjour", "c:/Bonjour.mp4");
        bibliotheque.add(el);
        Assertions.assertEquals(bibliotheque.size(), 1);
        bibliotheque.clear();
        Assertions.assertEquals(bibliotheque.size(), 0);
    }

    @Test
    public void TestEmpty(){
        Assertions.assertTrue(bibliotheque.isEmpty());
        IElements el = factory.newElements("Bonjour", "c:/Bonjour.mp4");
        bibliotheque.add(el);
        Assertions.assertEquals(bibliotheque.size(), 1);
        bibliotheque.clear();
        Assertions.assertEquals(bibliotheque.size(), 0);
    }

    @Test
    public void TestContains(){
        IElements el = factory.newElements("Bonjour", "c/Bonjour.mp4");
        bibliotheque.add(el);
        Assertions.assertEquals(bibliotheque.size(), 1);
        Assertions.assertTrue(bibliotheque.contains(el));
    }

}
