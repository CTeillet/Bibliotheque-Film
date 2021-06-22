package database;

import interfaces.database.IBDElements;
import interfaces.library.IElements;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import utils.Factory;

import java.sql.*;

public class BDElements implements IBDElements {
    static final Factory factory = Factory.getFact();

    public static boolean addElements(@NotNull IElements elements){
        String req = "INSERT INTO elements(path,title) VALUES(?,?);";
        return executeUpdate(elements, req);
    }

    public static boolean removeElements(IElements elements) {
        String req = "Delete from elements where path=? and title=?;";
        return executeUpdate(elements, req);
    }

    private static boolean executeUpdate(IElements elements, String req) {
        try (Connection conn = BDConnect.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(req)){
            preparedStatement.setString(1, elements.getEmplacement());
            preparedStatement.setString(2, elements.getTitre());
            int res = preparedStatement.executeUpdate();
            return res == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    public static int size() {
        String req = "Select Count(*) from elements;";
        try (Connection conn = BDConnect.connect();
             Statement statement = conn.createStatement()){
            ResultSet res = statement.executeQuery(req);
            return res.getInt("total");
        } catch (SQLException e) {
            return -1;
        }
    }

    public static void removeAllElements() {
        String req = "Delete from elements;";
        try (Connection conn = BDConnect.connect();
             Statement statement = conn.createStatement()){
            statement.executeUpdate(req);
        } catch (SQLException ignored) {
        }

    }

    public static IElements getElementByTitle(String title) {
        String req = "Select * from elements where title = ?;";
        return getElements(title, req);
    }

    public static IElements getElementByPath(String path) {
        String req = "Select * from elements where path = ?;";
        return getElements(path, req);
    }

    @Nullable
    private static IElements getElements(String elem, String req) {
        try (Connection conn = BDConnect.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(req)){
            preparedStatement.setString(1, elem);
            preparedStatement.execute();
            ResultSet res = preparedStatement.getResultSet();
            return factory.newElements(res.getString("path"), res.getString("title"));
        } catch (SQLException e) {
            return null;
        }
    }

    public static boolean containsElements(IElements elements) {
        String req = "Select Count(*) from elements where title=? and path=?";
        try (Connection conn = BDConnect.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(req)){
            preparedStatement.setString(1, elements.getTitre());
            preparedStatement.setString(2, elements.getEmplacement());
            preparedStatement.execute();
            ResultSet res = preparedStatement.getResultSet();
            return res.getInt("total")>0;
        } catch (SQLException e) {
            return false;
        }
    }
}
