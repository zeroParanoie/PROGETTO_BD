package engClasses.DAO;

import engClasses.ConnectionFactory;
import engClasses.exceptions.DAOexception;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornitoreDAO {

    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;

    public FornitoreDAO() {}

    public void acceptFornitura(int cForn, String specie) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("accetta_fornitura(?, ?)");
            callableStatement.setString(1, specie);
            callableStatement.setInt(2, cForn);
            callableStatement.executeQuery();
            System.out.println("Query andata a buon fine!");
        } catch (SQLException e) {}
    }

    public void updateSedi(int cForn, String sede) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("update_f_sedi(?, ?)");
            callableStatement.setString(1, sede);
            callableStatement.setInt(2, cForn);
            callableStatement.executeQuery();
            System.out.println("Query andata a buon fine!");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void addUser(String usr, String pw) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("aggiungi_utente(?, ?, ?)");
            callableStatement.setString(1, usr);
            callableStatement.setString(2, pw);
            callableStatement.setString(3, "f");
            callableStatement.executeQuery();
            System.out.println("Query andata a buon fine!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
