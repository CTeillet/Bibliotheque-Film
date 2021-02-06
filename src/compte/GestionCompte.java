package compte;

import interfaces.compte.IGestionCompte;
import interfaces.compte.IPersonne;
import utils.Factory;

import java.util.*;

public class GestionCompte implements IGestionCompte {
    private final Map<String, IPersonne> inscrits = new HashMap<>();
    private final Factory factory = Factory.getFact();

    @Override
    public boolean addPersonne(String nom, String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance) {
        if(inscrits.containsKey(identifiant)) return false;
        inscrits.put(identifiant, factory.newPersonne(prenom,  prenom, mail, identifiant, motDePasse, dateNaissance));
        return true;
    }

    @Override
    public boolean addPersonne(String mail, String identifiant, String motDePasse) {
        return this.addPersonne("", "", mail, identifiant, motDePasse, null);
    }

    @Override
    public boolean removePersonne(String identifiant) {
        return inscrits.remove(identifiant)!=null;
    }

    @Override
    public boolean isPassword(String identifiant, String motDePasse) {
        IPersonne pers = inscrits.get(identifiant);
        if(pers == null) return false;
        return pers.getMotDePasse().equals(motDePasse);
    }

    public int size(){
        return inscrits.size();
    }
}
