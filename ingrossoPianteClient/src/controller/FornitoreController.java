package controller;

import engClasses.ConnectionFactory;
import model.role;

import java.sql.SQLException;

public class FornitoreController implements Controller {

    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(role.FORNITORE);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
