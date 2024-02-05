package engClasses.DAO;

import engClasses.ConnectionFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReferenteDAO {
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;

    public ReferenteDAO() {
    }

    public void addContatto(String email, String IVA, String telefono, String cellulare) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("aggiungi_contatto(?,?,?,?)");
            callableStatement.setString(1, email);
            callableStatement.setString(2, IVA);
            callableStatement.setString(3, telefono);
            callableStatement.setString(4, cellulare);
            callableStatement.executeQuery();
            System.out.println("Query eseguita correttamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPiantaOrdine(String nome, int qta, String nomeRef, String cognomeRef, String recapito) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("ordina_piante_aggiungi(?,?,?,?,?)");
            callableStatement.setString(1, nome);
            callableStatement.setInt(2, qta);
            callableStatement.setString(3, nomeRef);
            callableStatement.setString(4, cognomeRef);
            callableStatement.setString(5, recapito);
            callableStatement.executeQuery();
            System.out.println("Query eseguita correttamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String trovaOrdine(int codice) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("trova_info_ordine(?)");
            callableStatement.setInt(1, codice);
            resultSet = callableStatement.executeQuery();
            return resultSet.getString("stato");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public float trovaUltimoPrezzo(String nome) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("trova_ultimo_prezzo(?)");
            callableStatement.setString(1, nome);
            resultSet = callableStatement.executeQuery();
            return resultSet.getFloat("costo");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void finalizza(int codice) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("update_ordine_finalizzato(?)");
            callableStatement.setInt(1, codice);
            callableStatement.executeQuery();
            System.out.println("Query eseguita correttamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSede(String IVA, String nuovaSede) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("update_sede_rivendita(?, ?)");
            callableStatement.setString(1, IVA);
            callableStatement.setString(2, nuovaSede);
            callableStatement.executeQuery();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String usr, String pw) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("aggiungi_utente(?,?,?)");
            callableStatement.setString(1, usr);
            callableStatement.setString(2, pw);
            callableStatement.setString(3, "r");
            callableStatement.executeQuery();
            System.out.println("Query eseguita correttamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
