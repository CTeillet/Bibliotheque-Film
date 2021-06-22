package account;

import interfaces.account.IPerson;

import java.util.Date;

public class Person implements IPerson {
    private final String nom;
    private final String prenom;
    private final String mail;
    private final String identifiant;
    private final String motDePasse;
    private final Date dateNaissance;


    public Person(String nom, String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
    }

    public Person(String mail, String identifiant, String motDePasse) {
        this("", "", mail, identifiant, motDePasse, null);
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public String getMotDePasse() {
        return motDePasse;
    }

    @Override
    public Date getDateNaissance() {
        return dateNaissance;
    }
}
