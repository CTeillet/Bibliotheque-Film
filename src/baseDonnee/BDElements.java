package baseDonnee;

import interfaces.baseDonnee.IBDElements;
import interfaces.bibliotheque.IElements;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDElements implements IBDElements {
    public static boolean addElements(IElements elements){
        String req = "INSERT INTO elements(emplacement,titre) VALUES(?,?);";
        try (Connection conn = BDConnect.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(req)){
            preparedStatement.setString(1, elements.getEmplacement());
            preparedStatement.setString(2, elements.getTitre());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
