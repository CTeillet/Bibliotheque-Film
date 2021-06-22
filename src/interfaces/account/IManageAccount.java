package interfaces.account;

import java.util.Date;

public interface IManageAccount {
    boolean addPersonne(String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance);
    boolean addPersonne(String mail, String identifiant, String motDePasse);
    boolean removePersonne(String identifiant);
    boolean isPassword(String identifiant, String motDePasse);
    int size();

}