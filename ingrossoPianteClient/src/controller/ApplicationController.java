package controller;

import model.Credentials;

public class ApplicationController implements Controller{
    Credentials credentials;

    @Override
    public void start() {
        LoginController loginController = new LoginController();
        loginController.start();

        credentials = loginController.getCredentials();

        if(credentials.getR() == null) {
            throw new RuntimeException("Credentials are wrong!");
        }

        switch (credentials.getR()) {
            case FORNITORE -> new FornitoreController().start();
            case MAGAZZINO -> new MagazzinoController().start();
            case REFERENTE -> new ReferenteController().start();
            default -> throw new RuntimeException("Credentials are wrong!");
        }
    }
}
