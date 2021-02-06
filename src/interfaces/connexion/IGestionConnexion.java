package interfaces.connexion;

public interface IGestionConnexion {
    boolean connect(String identifiant, String motDePasse);
    boolean isConnected(String identifiant);
    boolean disconnect(String identifiant);
    void setTimeBeforeDisconnect(int timeBeforeDisconnect);
}