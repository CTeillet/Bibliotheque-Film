package connexion;

import interfaces.compte.IGestionCompte;
import interfaces.connexion.IGestionConnexion;
import org.junit.jupiter.api.Test;
import utils.Factory;

import java.util.Date;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestGestionConnexion {
    private Factory factory = Factory.getFact();

    @Test
    public void TestConnect(){
        IGestionConnexion gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
    }

    @Test
    public void TestIsConnected(){
        IGestionConnexion gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
        assumeTrue(gestionConnexion.isConnected("nono"));
    }

    @Test
    public void TestDisconnect(){
        IGestionConnexion gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
        assumeTrue(gestionConnexion.disconnect("nono"));
    }

    @Test
    public void TestDisconnectProblem(){
        IGestionConnexion gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeFalse(gestionConnexion.disconnect("nono"));
    }

    @Test
    public void TestIsConnectedProblem(){
        IGestionConnexion gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
        gestionConnexion.setTimeBeforeDisconnect(0);
        assumeFalse(gestionConnexion.isConnected("nono"));
    }

    class BouchonCompte implements IGestionCompte{

        @Override
        public boolean addPersonne(String nom, String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance) {
            return true;
        }

        @Override
        public boolean addPersonne(String mail, String identifiant, String motDePasse) {
            return true;
        }

        @Override
        public boolean removePersonne(String identifiant) {
            return true;
        }

        @Override
        public boolean isPassword(String identifiant, String motDePasse) {
            return true;
        }

        @Override
        public int size() {
            return 0;
        }
    }
}
