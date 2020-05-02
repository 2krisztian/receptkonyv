
package receptkonyv;

/**
 *
 * @author tothk
 */
public class Recept {

    private int receptid;
    private String nev, kategoria, leiras1, leiras2, alkoto;
   
    

   
   

    public Recept(int receptid, String nev, String kategoria, String leiras1, String leiras2, String alkoto) {
        this.receptid = receptid;
        this.nev = nev;
        this.kategoria = kategoria;
        this.leiras1 = leiras1;
        this.leiras2 = leiras2;
        this.alkoto = alkoto;
    }

   

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getReceptid() {
        return receptid;
    }

    public void setReceptid(int receptid) {
        this.receptid = receptid;
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

    
 
   
}
//</editor-fold>

    
