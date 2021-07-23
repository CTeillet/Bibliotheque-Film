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

    public IPerson newPersonne(String name, String surname, String mail, String username, String password, Date birthDate){
        return new Person(name, surname, mail, username, password, birthDate);
    }
    public IPerson newPersonne(String mail, String username, String motDePasse){
        return new Person(mail, username, motDePasse);
    }
    public IManageAccount newGestionCompte(){
        return ManageAccount.getGestionCompte();
    }

    public IManageConnection newGestionConnexion(IManageAccount gestionCompte){
        return new ManageConnection(gestionCompte);
    }

    public IElements newElements(String title, String path){
        return new Elements(title, path);
    }


    public IFilm newFilm(String title, String path, String director, String duration, List<String> actors) {
        return new Film(title, path, director, duration, actors);
    }

    public ILibrary newLibrary() {
        return new Library();
    }

    public IManageLibrary newGestionLibrary(){
        return ManageLibrary.getInstance();
    }


}
