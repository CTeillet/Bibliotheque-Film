package interfaces.compte;

import java.util.Date;

public interface IGestionCompte {
    boolean addPersonne(String nom, String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance);
    boolean addPersonne(String mail, String identifiant, String motDePasse);
    boolean removePersonne(String identifiant);
    boolean isPassword(String identifiant, String motDePasse);
    int size();

}