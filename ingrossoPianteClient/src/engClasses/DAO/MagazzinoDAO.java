package engClasses.DAO;

import engClasses.ConnectionFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazzinoDAO {
    Connection connection = null;
    CallableStatement callableStatement = null;
    ResultSet resultSet = null;

    public MagazzinoDAO() {}
    public void addFornitore(String nome, String cognome, String CF, String nuovaSede, int codF)  {
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

    public void updatePrezzo(String specie, float nuovoPrezzo) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("modifica_prezzo(?, ?)");
            callableStatement.setString(1, specie);
            callableStatement.setFloat(2, nuovoPrezzo);
            callableStatement.executeQuery();
            System.out.println("Query andata a buon fine!");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void findInfoFornitrici(String CF, String sede, String nome, String cognome) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("trova_info_fornitrice(?, ?, ?, ?)");
            callableStatement.setString(1, CF);
            callableStatement.setString(2, sede);
            callableStatement.setString(3, nome);
            callableStatement.setString(4, cognome);
            resultSet = callableStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("sede_f") + " " + resultSet.getString("nomeFornitore") + " " + resultSet.getString("cognomeFornitore"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findFornitori() {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("trova_fornitori()");
            resultSet = callableStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("CF") + " " + resultSet.getString("nomeFornitore") + " " + resultSet.getString("cognomeFornitore") + " " + resultSet.getInt("Cfornitore") + " " + resultSet.getString("sedePos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String findOrder(int codice) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("trova_info_ordine(?)");
            callableStatement.setInt(1, codice);
            resultSet = callableStatement.executeQuery();
            return resultSet.getString("stato");
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void findRivendite() {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("trova_rivendite()");
            resultSet = callableStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("IVA") + " " + resultSet.getString("sede_rivendita"));
            }
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    public void findUltimoPrezzo(String nomeL) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("trova_ultimo_prezzo(?)");
            callableStatement.setString(1,nomeL);
            resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("costo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String usr, String pw) {
        try {
            connection = ConnectionFactory.getConnection();
            callableStatement = connection.prepareCall("aggiungi_utente(?, ?, ?)");
            callableStatement.setString(1, usr);
            callableStatement.setString(2, pw);
            callableStatement.setString(3, "v");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
