package view;

import engClasses.DAO.MagazzinoDAO;

import java.io.IOException;
import java.util.Scanner;

public class MagazzinoView {
    MagazzinoDAO magazzinoDAO = new MagazzinoDAO();

    public static int showMenu() throws IOException {
        System.out.println("Benvenuto nel sistema di gestione del magazzino di Verde S.r.l.");
        System.out.println("Scegliere una delle seguenti azioni: ");
        System.out.println("1. Aggiungi un fornitore;");
        System.out.println("2. Modifica un prezzo;");
        System.out.println("3. Trova fornitori;");
        System.out.println("4. Trova informazioni su una azienda fornitrice;");
        System.out.println("5. Trova informazioni su un ordine;");
        System.out.println("6. Trova informazioni su una rivendita;");
        System.out.println("7. Trova ultimo prezzo inserito;");
        System.out.println("8. Registra nuovo utente;");

        Scanner input = new Scanner(System.in);
        int choice = 0;

        while(true) {
            System.out.println("Inserire il numero della azione da svolgere: ");
            choice = input.nextInt();
            if(choice >= 1 && choice <= 8) {
                break;
            } else {
                System.out.println("Input non valido!");
            }
        }

        return choice;
    }
}
