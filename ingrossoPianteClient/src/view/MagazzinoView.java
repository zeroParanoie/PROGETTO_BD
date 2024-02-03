package view;

import java.io.IOException;
import java.util.Scanner;

public class MagazzinoView {
    public static int showMenu() throws IOException {
        System.out.println("Benvenuto nel sistema di gestione del magazzino di Verde S.r.l.");
        System.out.println("Scegliere una delle seguenti azioni: ");
        System.out.println("1. Approva una fornitura;");
        System.out.println("2. Modifica la tua sede;");
        System.out.println("3. Registra nuovo utente;");

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
