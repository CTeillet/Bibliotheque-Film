package bibliotheque;

import interfaces.bibliotheque.IBibliotheque;
import interfaces.bibliotheque.IElements;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque implements IBibliotheque {
    private final List<IElements> biblio = new ArrayList<>();

    public int size() {
        return biblio.size();
    }

    public boolean isEmpty() {
        return biblio.isEmpty();
    }

    public boolean contains(IElements e) {
        return biblio.contains(e);
    }

    public boolean add(IElements elements) {
        return biblio.add(elements);
    }

    public boolean remove(IElements e) {
        return biblio.remove(e);
    }

    public void clear() {
        biblio.clear();
    }

    public IElements get(int index) {
        return biblio.get(index);
    }
}
