package interfaces.library;

import java.util.List;

public interface IFilm extends IElements{
    String getDirector();
    String getDuration();
    List<String> getActors();
}
