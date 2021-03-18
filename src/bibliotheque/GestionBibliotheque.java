package bibliotheque;

import interfaces.bibliotheque.IElements;
import interfaces.bibliotheque.IGestionBibliotheque;

public class GestionBibliotheque implements IGestionBibliotheque {
    private Bibliotheque bibliotheque;

    public GestionBibliotheque(Bibliotheque bibliotheque) {
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


}
