package bibliotheque;

import interfaces.bibliotheque.IBibliotheque;
import interfaces.bibliotheque.IElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Factory;

public class TestBibliotheque {
    private IBibliotheque bibliotheque;
    private Factory factory = Factory.getFact();

    @BeforeEach
    private void initialize(){
        bibliotheque = factory.newBibliotheque();
    }

    @Test
    public void TestAjout(){
        IElements el = factory.newElements("Bonjour", "c/Bonjour.mp4");
        bibliotheque.add(el);
        Assertions.assertEquals(bibliotheque.size(), 1);
        Assertions.assertEquals(bibliotheque.get(0), el);
    }

    @Test
    public void TestClear(){
        IElements el = factory.newElements("Bonjour", "c/Bonjour.mp4");
        bibliotheque.add(el);
        Assertions.assertEquals(bibliotheque.size(), 1);
        bibliotheque.clear();
        Assertions.assertEquals(bibliotheque.size(), 0);
    }

    @Test
    public void TestEmpty(){
        Assertions.assertTrue(bibliotheque.isEmpty());
        IElements el = factory.newElements("Bonjour", "c/Bonjour.mp4");
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
