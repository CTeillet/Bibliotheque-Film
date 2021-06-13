package bibliotheque;

import interfaces.bibliotheque.IBibliotheque;
import interfaces.bibliotheque.IElements;
import interfaces.bibliotheque.IGestionBibliotheque;
import utils.Factory;

public class GestionBibliotheque implements IGestionBibliotheque {
    private IBibliotheque bibliotheque;
    private static final IGestionBibliotheque instance = new GestionBibliotheque();
    private Factory fact = Factory.getFact();


    public GestionBibliotheque(IBibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    @Override
    public int size() {
        return bibliotheque.size();
    }

    public boolean isEmpty() {
        return bibliotheque.isEmpty();
    }

    public boolean contains(IElements e) {
        return bibliotheque.contains(e);
    }

    public boolean add(IElements elements) {
        return bibliotheque.add(elements);
    }

    public boolean remove(IElements e) {
        return bibliotheque.remove(e);
    }

    public void clear() {
        bibliotheque.clear();
    }

    public IElements get(int index) {
        return bibliotheque.get(index);
    }

    private GestionBibliotheque(){
        bibliotheque = fact.newBibliotheque();
    }

    public static IGestionBibliotheque getInstance() {
        return instance;
    }
}
