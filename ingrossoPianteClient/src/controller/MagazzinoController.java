package controller;

import engClasses.ConnectionFactory;
import engClasses.DAO.MagazzinoDAO;
import model.role;
import view.MagazzinoView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MagazzinoController implements Controller {
    Scanner scanner = new Scanner(System.in);
    MagazzinoDAO magazzinoDAO = new MagazzinoDAO();
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
            switch (choice) {
                case 1 -> addFornitore();
                case 2 -> updatePrezzo();
                case 3 -> findFornitori();
                case 4 -> findInfoFornitrici();
                case 5 -> findOrder();
                case 6 -> findRivendita();
                case 7 -> findLastPrezzo();
                case 8 -> addUser();
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

        public void addFornitore() {
            String nome;
            String cognome;
            String CF;
            String sede;
            int codF;

            System.out.println("Inserire nome del nuovo fornitore: ");
            nome = scanner.nextLine();
            System.out.println("Inserire cognome del nuovo fornitore: ");
            cognome = scanner.nextLine();
            System.out.println("Inserire codice fiscale del nuovo fornitore: ");
            CF = scanner.nextLine();
            System.out.println("Inserire sede del nuovo fornitore: ");
            sede = scanner.nextLine();
            System.out.println("Inserire il codice fornitore del nuovo fornitore: ");
            codF = scanner.nextInt();

            magazzinoDAO.addFornitore(nome, cognome, CF, sede, codF);
        }

        public void updatePrezzo() {
            String specie;
            float prezzo;

            System.out.println("Inserire specie da modificare: ");
            specie = scanner.nextLine();
            System.out.println("Inserire il nuovo prezzo: ");
            prezzo = scanner.nextFloat();

            magazzinoDAO.updatePrezzo(specie, prezzo);
        }

        public void findFornitori() {
            magazzinoDAO.findFornitori();
        }

        public void findInfoFornitrici() {
            System.out.println("Inserire codice fiscale: ");
            String CF = scanner.nextLine();
            System.out.println("Inserire sede: ");
            String sede = scanner.nextLine();
            System.out.println("Inserire nome: ");
            String nome = scanner.nextLine();
            System.out.println("Inserire cognome: ");
            String cognome = scanner.nextLine();

            magazzinoDAO.findInfoFornitrici(CF, sede, nome, cognome);
        }

        public void findOrder() {
            System.out.println("Inserire il codice dell'ordine: ");
            int codice = scanner.nextInt();

            System.out.println("l'ordine è nello stato: " + magazzinoDAO.findOrder(codice));
        }

        public void findRivendita() {
            magazzinoDAO.findRivendite();
        }

        public void findLastPrezzo() {
            System.out.println("Inserire il nome latino della pianta: ");
            String nomeL = scanner.nextLine();

            magazzinoDAO.findUltimoPrezzo(nomeL);
        }

        public void addUser() {
            System.out.println("Inserire nuovo username: ");
            String usr = scanner.nextLine();
            System.out.println("Inserire nuova password: ");
            String pw = scanner.nextLine();

            magazzinoDAO.addUser(usr, pw);
        }
    }
