package connection;

import interfaces.account.IManageAccount;
import interfaces.connection.IManageConnection;
import org.junit.jupiter.api.Test;
import utils.Factory;

import java.util.Date;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestGestionConnection {
    private final Factory factory = Factory.getFact();

    @Test
    public void TestConnect(){
        IManageConnection gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
    }

    @Test
    public void TestIsConnected(){
        IManageConnection gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
        assumeTrue(gestionConnexion.isConnected("nono"));
    }

    @Test
    public void TestDisconnect(){
        IManageConnection gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
        assumeTrue(gestionConnexion.disconnect("nono"));
    }

    @Test
    public void TestDisconnectProblem(){
        IManageConnection gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeFalse(gestionConnexion.disconnect("nono"));
    }

    @Test
    public void TestIsConnectedProblem(){
        IManageConnection gestionConnexion = factory.newGestionConnexion(new BouchonCompte());
        assumeTrue(gestionConnexion.connect("nono", "azerty"));
        gestionConnexion.setTimeBeforeDisconnect(0);
        assumeFalse(gestionConnexion.isConnected("nono"));
    }

    static class BouchonCompte implements IManageAccount {

        @Override
        public boolean addPersonne(String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance) {
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
