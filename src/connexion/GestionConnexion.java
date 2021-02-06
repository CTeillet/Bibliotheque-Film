package connexion;

import interfaces.compte.IGestionCompte;
import interfaces.connexion.IGestionConnexion;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class GestionConnexion implements IGestionConnexion {
    private int timeBeforeDisconnect = 10;
    private final Map<String, Date> connected = new HashMap<>();
    private final IGestionCompte gestionCompte;

    public GestionConnexion(IGestionCompte gestionCompte){
        this.gestionCompte = gestionCompte;
    }

    @Override
    public boolean connect(String identifiant, String motDePasse) {
        if(gestionCompte.isPassword(identifiant, motDePasse)){
            connected.put(identifiant, new Date());
            return true;
        }else return false;
    }

    @Override
    public boolean isConnected(String identifiant) {
        Date temp = connected.get(identifiant);
        if( temp != null){
            Date now = new Date();

            if(TimeUnit.MILLISECONDS.toMinutes(now.getTime()-temp.getTime())<timeBeforeDisconnect) {
                connected.put(identifiant, now);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean disconnect(String identifiant) {
        Object temp = connected.remove(identifiant);
        return temp!=null;
    }

    @Override
    public void setTimeBeforeDisconnect(int timeBeforeDisconnect) {
        this.timeBeforeDisconnect = timeBeforeDisconnect;
    }
}
