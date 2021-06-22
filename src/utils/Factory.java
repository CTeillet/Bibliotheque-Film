package utils;

import library.Library;
import library.Elements;
import library.Film;
import library.ManageLibrary;
import account.ManageAccount;
import account.Person;
import connection.ManageConnection;
import interfaces.library.ILibrary;
import interfaces.library.IElements;
import interfaces.library.IFilm;
import interfaces.library.IManageLibrary;
import interfaces.account.IManageAccount;
import interfaces.account.IPerson;
import interfaces.connection.IManageConnection;

import java.util.Date;
import java.util.List;

public class Factory {
    private static final Factory fact = new Factory();
    public static Factory getFact() {
        return fact;
    }

    public IPerson newPersonne(String nom, String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance){
        return new Person(nom, prenom, mail, identifiant, motDePasse, dateNaissance);
    }
    public IPerson newPersonne(String mail, String identifiant, String motDePasse){
        return new Person(mail, identifiant, motDePasse);
    }
    public IManageAccount newGestionCompte(){
        return ManageAccount.getGestionCompte();
    }

    public IManageConnection newGestionConnexion(IManageAccount gestionCompte){
        return new ManageConnection(gestionCompte);
    }

    public IElements newElements(String titre, String emplacement){
        return new Elements(titre, emplacement);
    }


    public IFilm newFilm(String titre, String emplacement, String realisateur, String duree, List<String> acteurs) {
        return new Film(titre, emplacement, realisateur, duree, acteurs);
    }

    public ILibrary newBibliotheque() {
        return new Library();
    }

    public IManageLibrary newGestionBibliotheque(){
        return ManageLibrary.getInstance();
    }


}
