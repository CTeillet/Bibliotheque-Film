package interfaces.bibliotheque;

public interface IBibliotheque {
    int size();
    boolean contains(IElements e);
    boolean add(IElements elements);
    boolean remove(IElements e);
    void clear();
    IElements get(int index);
    boolean isEmpty();
}
