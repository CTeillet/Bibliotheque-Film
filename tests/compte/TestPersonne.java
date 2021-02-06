package compte;

import interfaces.compte.IPersonne;
import org.junit.jupiter.api.Test;
import utils.Factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPersonne {
    Factory fact = Factory.getFact();

    @Test
    void TestNormal() throws ParseException {
        String sDate1="30/07/1999";
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        IPersonne pers = fact.newPersonne("Teillet", "Corentin", "teillet.corentin@neuf.fr",
                "nono", "azerty", date);
        assertEquals(pers.getPrenom(), "Corentin");
        assertEquals(pers.getNom(), "Teillet");
        assertEquals(pers.getMail(), "teillet.corentin@neuf.fr");
        assertEquals(pers.getIdentifiant(), "nono");
        assertEquals(pers.getMotDePasse(), "azerty");
    }

    @Test
    void TestSeulementParamètresObligatoires() throws ParseException {
        IPersonne pers = fact.newPersonne("teillet.corentin@neuf.fr",
                "nono", "azerty");
        assertEquals(pers.getPrenom(), "");
        assertEquals(pers.getNom(), "");
        assertEquals(pers.getMail(), "teillet.corentin@neuf.fr");
        assertEquals(pers.getIdentifiant(), "nono");
        assertEquals(pers.getMotDePasse(), "azerty");
        assertEquals(pers.getDateNaissance(), null);
    }


}
