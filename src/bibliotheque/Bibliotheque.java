package bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private final List<Elements> biblio = new ArrayList<>();

    public int size() {
        return biblio.size();
    }

    public boolean isEmpty() {
        return biblio.isEmpty();
    }

    public boolean contains(Elements e) {
        return biblio.contains(e);
    }

    public boolean add(Elements elements) {
        return biblio.add(elements);
    }

    public boolean remove(Elements e) {
        return biblio.remove(e);
    }

    public void clear() {
        biblio.clear();
    }

    public Elements get(int index) {
        return biblio.get(index);
    }
}
