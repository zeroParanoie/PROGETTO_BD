package controller;

import engClasses.ConnectionFactory;
import model.role;
import view.FornitoreView;
import view.MagazzinoView;

import java.io.IOException;
import java.sql.SQLException;

public class MagazzinoController implements Controller {
    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(role.MAGAZZINO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            int choice;
            try {
                choice = MagazzinoView.showMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}