package controller;

import engClasses.ConnectionFactory;
import model.role;

import java.sql.SQLException;

public class ReferenteController implements Controller {

    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(role.REFERENTE);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
