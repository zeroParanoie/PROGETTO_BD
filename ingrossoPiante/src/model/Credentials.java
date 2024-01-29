package model;

import model.role;
public class Credentials {
    private String usrn;
    private String pw;
    private role r;

    public Credentials(String usrn, String pw, role r) {
        this.usrn = usrn;
        this.pw = pw;
        this.r = r;
    }

    public String getUsrn() { return usrn; }

    public String getPw() {
        return pw;
    }

    public role getR() {
        return r;
    }
}
