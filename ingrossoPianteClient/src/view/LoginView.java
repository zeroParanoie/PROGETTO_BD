package view;

import model.Credentials;
import model.role;

import java.io.*;

public class LoginView {

    public static Credentials auth() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Insert username: ");
        String usr = reader.readLine();
        System.out.print("Insert password: ");
        String pw = reader.readLine();

        return new Credentials(usr, pw, null);
    }
}
