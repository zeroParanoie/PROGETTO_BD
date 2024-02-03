package controller;

import engClasses.ConnectionFactory;
import engClasses.DAO.FornitoreDAO;
import engClasses.exceptions.DAOexception;
import model.role;
import view.FornitoreView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class FornitoreController implements Controller {
    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    @Override
    public void start() {
        try {
            ConnectionFactory.changeRole(role.FORNITORE);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            int choice;
            try {
                choice = FornitoreView.showMenu();
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1 -> {
                    try {
                        accettaFornitura();
                    } catch (DAOexception e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> {
                    try {
                        updateSede();
                    } catch (DAOexception e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    try {
                        addUser();
                    } catch (DAOexception e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public void accettaFornitura() throws DAOexception {
        Scanner scanner = new Scanner(System.in);
        String specie;
        int codF;

        System.out.println("Inserire specie da approvare: ");
        specie = scanner.nextLine();
        System.out.println("Inserire il proprio codice fornitore: ");
        codF = scanner.nextInt();

        fornitoreDAO.acceptFornitura(codF, specie);
    }

    public void updateSede() throws  DAOexception {
        Scanner scanner = new Scanner(System.in);
        int codF;
        String sede;

        System.out.println("Inserire codice fornitore: ");
        codF = scanner.nextInt();
        System.out.println("Inserire nuova sede: ");
        sede = scanner.nextLine();

        fornitoreDAO.updateSedi(codF, sede);
    }

    public void addUser() throws DAOexception {
        Scanner scanner = new Scanner(System.in);
        String usr;
        String pw;

        System.out.println("Inserire username per il nuovo utente: ");
        usr = scanner.nextLine();
        System.out.println("Inserire password per il nuovo utente: ");
        pw = scanner.nextLine();

        fornitoreDAO.addUser(usr, pw);
    }

}
