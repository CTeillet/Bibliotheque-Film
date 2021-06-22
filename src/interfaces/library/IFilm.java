package interfaces.library;

import java.util.List;

public interface IFilm extends IElements{
    String getRealisateur();
    String getDuree();
    List<String> getActeurs();
}
