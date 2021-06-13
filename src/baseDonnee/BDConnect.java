package baseDonnee;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnect {
    /**
     * Connect to a sample database
     */
    public static Connection connect() throws SQLException{

        // db parameters
        String url = "jdbc:sqlite:../../bibliotheque.sqlite";
        // create a connection to the database

        return DriverManager.getConnection(url);
    }

}
