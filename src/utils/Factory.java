package utils;

import bibliotheque.Bibliotheque;
import bibliotheque.Elements;
import bibliotheque.Film;
import compte.GestionCompte;
import compte.Personne;
import connexion.GestionConnexion;
import interfaces.bibliotheque.IBibliotheque;
import interfaces.bibliotheque.IElements;
import interfaces.bibliotheque.IFilm;
import interfaces.compte.IGestionCompte;
import interfaces.compte.IPersonne;
import interfaces.connexion.IGestionConnexion;

import java.util.Date;
import java.util.List;

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

    public IElements newElements(String titre, String emplacement){
        return new Elements(titre, emplacement);
    }
    public static Factory getFact() {
        return fact;
    }

    public IFilm newFilm(String titre, String emplacement, String realisateur, String duree, List<String> acteurs) {
        return new Film(titre, emplacement, realisateur, duree, acteurs);
    }

    public IBibliotheque newBibliotheque() {
        return new Bibliotheque();
    }
}
