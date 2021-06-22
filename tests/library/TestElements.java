package library;

import interfaces.library.IElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Factory;

public class TestElements {
    private final Factory fact = Factory.getFact();

    @Test
    public void TestElementsCreation(){
        IElements elements = fact.newElements("Bonjour", "c:/bonjour.mp4");
        Assertions.assertEquals(elements.getTitre(), "Bonjour");
        Assertions.assertEquals(elements.getEmplacement(), "c:/bonjour.mp4");
    }

}
