package engClasses.DAO;

import engClasses.ConnectionFactory;
import engClasses.exceptions.DAOexception;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazzinoDAO {
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;

    public void addFornitore(String nome, String cognome, String CF, String nuovaSede, int codF) throws DAOexception {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("aggiungi_fornitore(?, ?, ?, ?, ?)");
            callableStatement.setString(1, nome);
            callableStatement.setString(2, cognome);
            callableStatement.setString(3, CF);
            callableStatement.setString(4, nuovaSede);
            callableStatement.setInt(5, codF);
            callableStatement.executeQuery();
            System.out.println("query andata a buon fine!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
