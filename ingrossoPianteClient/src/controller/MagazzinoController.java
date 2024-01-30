package controller;

import engClasses.ConnectionFactory;
import model.role;

import java.sql.SQLException;

public class MagazzinoController implements Controller {
    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(role.MAGAZZINO);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
