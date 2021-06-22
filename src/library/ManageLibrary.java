package library;

import interfaces.library.ILibrary;
import interfaces.library.IElements;
import interfaces.library.IManageLibrary;
import utils.Factory;

public class ManageLibrary implements IManageLibrary {
    private final ILibrary library;
    private static final IManageLibrary instance = new ManageLibrary();


    public ManageLibrary(ILibrary library) {
        this.library = library;
    }

    @Override
    public int size() {
        return library.size();
    }

    public boolean isEmpty() {
        return library.isEmpty();
    }

    public boolean contains(IElements e) {
        return library.contains(e);
    }

    public boolean add(IElements elements) {
        return library.add(elements);
    }

    public boolean remove(IElements e) {
        return library.remove(e);
    }

    public void clear() {
        library.clear();
    }

    @Override
    public IElements get(int index) {
        return null;
    }

    private ManageLibrary(){
        Factory fact = Factory.getFact();
        library = fact.newBibliotheque();
    }

    public static IManageLibrary getInstance() {
        return instance;
    }
}
