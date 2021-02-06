package interfaces.compte;

import java.util.Date;

public interface IPersonne {
    String getNom();

    String getPrenom();

    String getMail();

    String getIdentifiant();

    String getMotDePasse();

    Date getDateNaissance();
}
