package controller;

import engClasses.ConnectionFactory;
import engClasses.DAO.ReferenteDAO;
import model.role;
import view.FornitoreView;
import view.ReferenteView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ReferenteController implements Controller {
    Scanner scanner = new Scanner(System.in);
    ReferenteDAO referenteDAO = new ReferenteDAO();
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
            switch (choice) {
                case 1 -> addContatto();
                case 2 -> aggiungiPiantaOrdine();
                case 3 -> trovaOrdine();
                case 4 -> trovaUltimoPrezzo();
                case 5 -> finalizza();
                case 6 -> updateSede();
                case 7 -> addUtente();
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public void addContatto() {
        System.out.println("Inserire email: ");
        String email = scanner.nextLine();
        System.out.println("Inserire IVA della rivendita: ");
        String IVA = scanner.nextLine();
        System.out.println("Inserire telefono: ");
        String telefono = scanner.nextLine();
        System.out.println("Inserire cellulare: ");
        String cellulare = scanner.nextLine();

        referenteDAO.addContatto(email, IVA, telefono, cellulare);
    }
    public void aggiungiPiantaOrdine() {
        System.out.println("inserire nome pianta: ");
        String nomeP = scanner.nextLine();
        System.out.println("inserire quantita' desiderata");
        int qta = scanner.nextInt();
        System.out.println("inserire nome del referente: ");
        String nome = scanner.nextLine();
        System.out.println("inserire cognome del referente: ");
        String cognome = scanner.nextLine();
        System.out.println("inserire recapito: ");
        String recapito = scanner.nextLine();

        referenteDAO.addPiantaOrdine(nomeP, qta, nome, cognome, recapito);
    }
    public void trovaOrdine() {
        System.out.println("Inserire codice ordine: ");
        int cod = scanner.nextInt();

        String stato = referenteDAO.trovaOrdine(cod);
        System.out.println("Stato: " + stato);
    }
    public void trovaUltimoPrezzo() {
        System.out.println("Inserire nome pianta: ");
        String nome = scanner.nextLine();

        float prezzo = referenteDAO.trovaUltimoPrezzo(nome);
        System.out.println(prezzo);
    }
    public void finalizza() {
        System.out.println("Inserire codice ordine: ");
        int cod = scanner.nextInt();

        referenteDAO.finalizza(cod);
    }
    public void updateSede() {
        System.out.println("Inserire p. IVA: ");
        String IVA = scanner.nextLine();
        System.out.println("Inserire nuova sede: ");
        String nuovaSede = scanner.nextLine();

        referenteDAO.updateSede(IVA, nuovaSede);
    }
    public void addUtente() {
        System.out.println("Inserire username: ");
        String usr = scanner.nextLine();
        System.out.println("Inserire password: ");
        String pw = scanner.nextLine();

        referenteDAO.addUser(usr, pw);
    }
}
