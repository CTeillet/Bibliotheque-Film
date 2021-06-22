package interfaces.account;

import java.util.Date;

public interface IPerson {
    String getNom();

    String getPrenom();

    String getMail();

    String getIdentifiant();

    String getMotDePasse();

    Date getDateNaissance();
}
