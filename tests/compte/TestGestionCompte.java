package compte;

import interfaces.compte.IGestionCompte;
import org.junit.jupiter.api.Test;
import utils.Factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGestionCompte {
    private Factory factory = Factory.getFact();

    @Test
    public void TestAjout(){
        IGestionCompte gestionCompte = factory.newGestionCompte();
        assertEquals(gestionCompte.size(), 0);
        assertEquals(gestionCompte.addPersonne("teillet.corentin@neuf.fr", "nono", "azerty"),
                true);
        assertEquals(gestionCompte.size(), 1);
    }

    @Test
    public void TestSuppression(){
        IGestionCompte gestionCompte = factory.newGestionCompte();
        gestionCompte.addPersonne("teillet.corentin@neuf.fr", "nono", "azerty");
        assertEquals(gestionCompte.removePersonne("nono"), true);
    }

    @Test
    public void TestPassword(){
        IGestionCompte gestionCompte = factory.newGestionCompte();
        gestionCompte.addPersonne("teillet.corentin@neuf.fr", "nono", "azerty");
        assertEquals(gestionCompte.isPassword("nono", "azerty"), true);
    }
}
