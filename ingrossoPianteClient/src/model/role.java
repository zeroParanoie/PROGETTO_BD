package model;

public enum role {
    REFERENTE(1),
    FORNITORE(2),
    MAGAZZINO(3);

    private int id;

    private role(int id) { this.id = id; }

    public static role fromInt(int id) {
        for(role type : values()) {
            if(type.getId() == id) {
                return type;
            }
        }
        return null;
    }

    public int getId() { return id; }
}
