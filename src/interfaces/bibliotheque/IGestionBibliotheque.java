package interfaces.bibliotheque;

import bibliotheque.Elements;

public interface IGestionBibliotheque {
    int size();
    boolean isEmpty();
    boolean contains(IElements e);
    boolean add(IElements e);
    boolean remove(IElements e);
    void clear();
    IElements get(int index);

}
