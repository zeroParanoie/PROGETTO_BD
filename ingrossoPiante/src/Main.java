import controller.ApplicationController;
import engClasses.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {
        //ApplicationController applicationController = new ApplicationController();
        //applicationController.start();

        Connection conn = ConnectionFactory.getConnection();
        }
    }
}