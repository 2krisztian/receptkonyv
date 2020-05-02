package receptkonyv;

public class Kedvenc {

    private int receptid;
    private int kedvencekreceptid;
    private String kedvencekfhNEV;
    private String nev, kategoria, leiras1, leiras2, alkoto;
    private boolean kedvencekkedvenc;
    private boolean kedvenc;

    public Kedvenc(int receptid, String fhNEV, boolean kedvenc) {
        this.kedvencekreceptid = receptid;
        this.kedvencekfhNEV = fhNEV;
        this.kedvenc = kedvenc;
    }

    public Kedvenc(int recept_receptid, String recept_nev, String recept_kategoria, String recept_leiras1, String recept_leiras2,
             String recept_alkoto, int kedvencekreceptid, String kedvencekfhNEV, boolean kedvencekkedvenc) {
        this.receptid = recept_receptid;
        this.nev = recept_nev;
        this.kategoria = recept_kategoria;
        this.leiras1 = recept_leiras1;
        this.leiras2 = recept_leiras2;
        this.alkoto = recept_alkoto;
        this.kedvencekreceptid = kedvencekreceptid;
        this.kedvencekfhNEV = kedvencekfhNEV;
        this.kedvencekkedvenc = true;

    }

    public Kedvenc(int recept_receptid, String recept_nev, String recept_kategoria, String recept_leiras1, String recept_leiras2,
             String recept_alkoto) {
        this.receptid = recept_receptid;
        this.nev = recept_nev;
        this.kategoria = recept_kategoria;
        this.leiras1 = recept_leiras1;
        this.leiras2 = recept_leiras2;
        this.alkoto = recept_alkoto;

    }
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getReceptid() {
        return receptid;
    }

    public void setReceptid(int receptid) {
        this.receptid = receptid;
    }

    public int getKedvencekreceptid() {
        return kedvencekreceptid;
    }

    public void setKedvencekreceptid(int kedvencekreceptid) {
        this.kedvencekreceptid = kedvencekreceptid;
    }

    public String getKedvencekfhNEV() {
        return kedvencekfhNEV;
    }

    public void setKedvencekfhNEV(String kedvencekfhNEV) {
        this.kedvencekfhNEV = kedvencekfhNEV;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getLeiras1() {
        return leiras1;
    }

    public void setLeiras1(String leiras1) {
        this.leiras1 = leiras1;
    }

    public String getLeiras2() {
        return leiras2;
    }

    public void setLeiras2(String leiras2) {
        this.leiras2 = leiras2;
    }

    public String getAlkoto() {
        return alkoto;
    }

    public void setAlkoto(String alkoto) {
        this.alkoto = alkoto;
    }

    public boolean isKedvencekkedvenc() {
        return kedvencekkedvenc;
    }

    public void setKedvencekkedvenc(boolean kedvencekkedvenc) {
        this.kedvencekkedvenc = kedvencekkedvenc;
    }

    public boolean isKedvenc() {
        return kedvenc;
    }

    public void setKedvenc(boolean kedvenc) {
        this.kedvenc = kedvenc;
    }
//</editor-fold>
}
