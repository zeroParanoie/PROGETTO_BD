package engClasses.DAO;

import java.sql.*;

import engClasses.ConnectionFactory;
import engClasses.exceptions.DAOexception;
import model.Credentials;
import model.role;
public class LoginDAO {
    public Credentials execute(Object ... params) throws DAOexception {
        String usr = (String) params[0];
        String pw = (String) params[1];
        int r;

        try {
            Connection conn = ConnectionFactory.getConnection();
            CallableStatement cs = conn.prepareCall("{call login(?,?,?)}");
            cs.setString(1, usr);
            cs.setString(2, pw);
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.executeQuery();
            r = cs.getInt(3);
        } catch(SQLException e) {
            throw new DAOexception("Error in login: " + e.getMessage());
        }

        return new Credentials(usr, pw, role.fromInt(r));
    }
}
