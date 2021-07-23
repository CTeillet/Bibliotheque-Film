package library;

import interfaces.library.ILibrary;
import interfaces.library.IElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Factory;

public class TestLibrary {
    private final Factory factory = Factory.getFact();
    private ILibrary library = factory.newLibrary();

    @Test
    public void TestAjout(){
        IElements el = factory.newElements("Bonjour", "c:/Bonjour.mp4");
        library.add(el);
        Assertions.assertEquals(library.size(), 1);
    }

    @Test
    public void TestClear(){
        IElements el = factory.newElements("Bonjour", "c:/Bonjour.mp4");
        library.add(el);
        Assertions.assertEquals(library.size(), 1);
        library.clear();
        Assertions.assertEquals(library.size(), 0);
    }

    @Test
    public void TestEmpty1(){
        Assertions.assertTrue(library.isEmpty());
        Assertions.assertEquals(library.size(), 0);
    }

    @Test
    public void TestEmpty(){
        Assertions.assertTrue(library.isEmpty());
        IElements el = factory.newElements("Bonjour", "c:/Bonjour.mp4");
        library.add(el);
        Assertions.assertEquals(library.size(), 1);
        library.clear();
        Assertions.assertEquals(library.size(), 0);
    }

    @Test
    public void TestContains(){
        IElements el = factory.newElements("Bonjour", "c/Bonjour.mp4");
        library.add(el);
        System.out.println("Taille : " + library.size());
        Assertions.assertEquals(1, library.size());
        Assertions.assertTrue(library.contains(el));
    }

}
