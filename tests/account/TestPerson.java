package account;

import interfaces.account.IPerson;
import org.junit.jupiter.api.Test;
import utils.Factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestPerson {
    final Factory fact = Factory.getFact();

    @Test
    void TestNormal() throws ParseException {
        String sDate1="30/07/1999";
        Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        IPerson pers = fact.newPersonne("Teillet", "Corentin", "teillet.corentin@neuf.fr",
                "nono", "azerty", date);
        assertEquals(pers.getPrenom(), "Corentin");
        assertEquals(pers.getNom(), "Teillet");
        assertEquals(pers.getMail(), "teillet.corentin@neuf.fr");
        assertEquals(pers.getIdentifiant(), "nono");
        assertEquals(pers.getMotDePasse(), "azerty");
    }

    @Test
    void TestSeulementParamètresObligatoires() {
        IPerson pers = fact.newPersonne("teillet.corentin@neuf.fr",
                "nono", "azerty");
        assertEquals(pers.getPrenom(), "");
        assertEquals(pers.getNom(), "");
        assertEquals(pers.getMail(), "teillet.corentin@neuf.fr");
        assertEquals(pers.getIdentifiant(), "nono");
        assertEquals(pers.getMotDePasse(), "azerty");
        assertNull(pers.getDateNaissance());
    }


}
