package utils;

import compte.GestionCompte;
import compte.Personne;
import connexion.GestionConnexion;
import interfaces.compte.IGestionCompte;
import interfaces.compte.IPersonne;
import interfaces.connexion.IGestionConnexion;

import java.util.Date;

public class Factory {
    private static Factory fact = new Factory();

    public IPersonne newPersonne(String nom, String prénom, String mail, String identifiant, String motDePasse, Date dateNaissance){
        return new Personne(nom, prénom, mail, identifiant, motDePasse, dateNaissance);
    }
    public IPersonne newPersonne(String mail, String identifiant, String motDePasse){
        return new Personne(mail, identifiant, motDePasse);
    }
    public IGestionCompte newGestionCompte(){
        return new GestionCompte();
    }

    public IGestionConnexion newGestionConnexion(IGestionCompte gestionCompte){
        return new GestionConnexion(gestionCompte);
    }

    public static Factory getFact() {
        return fact;
    }
}
