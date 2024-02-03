package view;

import java.io.IOException;
import java.util.Scanner;

public class ReferenteView {
    public static int showMenu() throws IOException {
        System.out.println("Benvenuto nel sistema di gestione delle rivendite associate alla Verde S.r.l.");
        System.out.println("Scegliere una delle seguenti azioni: ");
        System.out.println("1. Aggiungi un contatto;");
        System.out.println("2. Aggiungi una pianta all'ordine;");
        System.out.println("3. Trova informazioni su un ordine;");
        System.out.println("4. Trova ultimo prezzo inserito su una pianta;");
        System.out.println("5. Finalizza un ordine;");
        System.out.println("6. Modifica la sede della tua rivendita;");
        System.out.println("7. Registra nuovo utente;");

        Scanner input = new Scanner(System.in);
        int choice = 0;

        while(true) {
            System.out.println("Inserire il numero della azione da svolgere: ");
            choice = input.nextInt();
            if(choice >= 1 && choice <= 7) {
                break;
            } else {
                System.out.println("Input non valido!");
            }
        }

        return choice;
    }
}
