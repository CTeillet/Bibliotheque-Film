package account;

import interfaces.account.IManageAccount;
import interfaces.account.IPerson;
import utils.Factory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ManageAccount implements IManageAccount {
    private final Map<String, IPerson> inscrits = new HashMap<>();
    private final Factory factory = Factory.getFact();

    private static final IManageAccount instance = new ManageAccount();

    public static IManageAccount getGestionCompte() {
        return instance;
    }

    @Override
    public boolean addPersonne(String prenom, String mail, String identifiant, String motDePasse, Date dateNaissance) {
        if(inscrits.containsKey(identifiant)) return false;
        inscrits.put(identifiant, factory.newPersonne(prenom,  prenom, mail, identifiant, motDePasse, dateNaissance));
        return true;
    }

    @Override
    public boolean addPersonne(String mail, String identifiant, String motDePasse) {
        return this.addPersonne("", mail, identifiant, motDePasse, null);
    }

    @Override
    public boolean removePersonne(String identifiant) {
        return inscrits.remove(identifiant)!=null;
    }

    @Override
    public boolean isPassword(String identifiant, String motDePasse) {
        IPerson pers = inscrits.get(identifiant);
        if(pers == null) return false;
        return pers.getMotDePasse().equals(motDePasse);
    }

    public int size(){
        return inscrits.size();
    }

    private ManageAccount(){}
}
