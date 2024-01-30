package controller;

import engClasses.DAO.LoginDAO;
import engClasses.exceptions.DAOexception;
import model.Credentials;
import java.io.*;
import view.LoginView;

public class LoginController implements Controller {
    private Credentials credentials = null;


    @Override
    public void start() {
        try {
            credentials = LoginView.auth();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        try {
            credentials = new LoginDAO().execute(credentials.getUsrn(), credentials.getPw(), credentials.getR());
        } catch (DAOexception e){
            throw new RuntimeException(e);
        }
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
