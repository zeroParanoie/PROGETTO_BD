package controller;

import engClasses.ConnectionFactory;
import model.role;
import view.FornitoreView;
import view.ReferenteView;

import java.io.IOException;
import java.sql.SQLException;

public class ReferenteController implements Controller {

    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(role.REFERENTE);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = ReferenteView.showMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
