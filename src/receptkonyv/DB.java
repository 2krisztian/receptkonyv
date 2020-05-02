
package receptkonyv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.ObservableList;

/**
 *
 * @author tothk
 */
public class DB {

    final String db = "jdbc:mysql://localhost:3306/receptkonyv"
            + "?useUnicode=true&characterEncoding=UTF-8";
    final String user = "chef";
    final String pass = "chef";

    public void beolvas(ObservableList<Recept> tabla) {
        String s = "select * from recept order by receptid; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            tabla.clear();

            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {
                tabla.add(new Recept(
                        ered.getInt("receptid"),
                        ered.getString("nev"),
                        ered.getString("kategoria"),
                        ered.getString("leiras1"),
                        ered.getString("leiras2"),
                        ered.getString("alkoto")
                ));
            }
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }

    public void keresem(ObservableList<Recept> tabla, String sql) {

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(sql)) {
            tabla.clear();

            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {
                tabla.add(new Recept(
                        ered.getInt("receptid"),
                        ered.getString("nev"),
                        ered.getString("kategoria"),
                        ered.getString("leiras1"),
                        ered.getString("leiras2"),
                        ered.getString("alkoto")
                ));
            }
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }

    public void kedvencekkeresem(ObservableList<Kedvenc> tabla, String sql) {

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(sql)) {
            tabla.clear();

            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {
                tabla.add(new Kedvenc(
                        ered.getInt("receptid"),
                        ered.getString("nev"),
                        ered.getString("kategoria"),
                        ered.getString("leiras1"),
                        ered.getString("leiras2"),
                        ered.getString("alkoto")
                ));
            }
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }

    public int hozzaad(String nev, String kategoria, String leiras1, String leiras2, String alkoto) {
        String s = "insert into recept (nev, kategoria,leiras1,leiras2, alkoto) values (?,?,?,?,?); ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {

            ekp.setString(1, nev);
            ekp.setString(2, kategoria);
            ekp.setString(3, leiras1);
            ekp.setString(4, leiras2);
            ekp.setString(5, alkoto);

            return ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return 0;
        }
    }

    public int receptidlekerdezo() {
        String s = "select max(receptid) as maxid from recept ; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {

            ResultSet ered = ekp.executeQuery();
            int maxid = -1;
            while (ered.next()) {

                maxid = ered.getInt("maxid");
            }
            return maxid;
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return -1;
        }
    }

    public boolean nevvizsgalat(String nev) {
        String s = "SELECT COUNT(nev) as Darab FROM recept WHERE nev=?; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            int vane = 0;
            ekp.setString(1, nev);
            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {

                vane = ered.getInt("Darab");
            }

            return vane > 0;
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return true;
        }

    }

    public int modosit(String nev, String kategoria, String leiras1, String leiras2, int receptid) {
        String s = "update recept set nev=?, kategoria=?, leiras1=?, leiras2=? where receptid=? ;";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, nev);
            ekp.setString(2, kategoria);
            ekp.setString(3, leiras1);
            ekp.setString(4, leiras2);
            ekp.setInt(5, receptid);

            return ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return 0;
        }
    }

    public int torol(int receptid, String alkoto) {
        String s = "delete from recept where receptid=? and alkoto=?; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setInt(1, receptid);
            ekp.setString(2, alkoto);
            return ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return 0;
        }
    } 

    public int felhasznalohozzaad(String fhNEV, String fhEmail, String fhJelszo) {
        String s = "insert into felhasznalok (fhNEV,fhJelszo,fhEmail) values (?,?,?); ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {

            ekp.setString(1, fhNEV);
            ekp.setString(2, fhJelszo);
            ekp.setString(3, fhEmail);

            return ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return 0;
        }
    }

    public boolean felhasznalonevvizsgalat(String fhNEV) {
        String s = "SELECT COUNT(fhNEV) as Darab FROM felhasznalok WHERE fhNEV=?; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            int vane = 0;
            ekp.setString(1, fhNEV);
            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {

                vane = ered.getInt("Darab");
            }

            return vane > 0;
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", "rosszdb");
            return true;
        }

    }

    public String jelszovizsgalat(String fhNEV) {
        String s = "SELECT fhJelszo from felhasznalok where fhNEV=?; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            String vane = "";
            ekp.setString(1, fhNEV);
            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {

                vane = ered.getString("fhJelszo");
            }

            return vane;
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", "Rossz DB!");
            return "";
        }

    }

    public void sajatok(ObservableList<Recept> tabla, String alkoto) {
        String s = "select * from recept where alkoto=?; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            tabla.clear();
            ekp.setString(1, alkoto);
            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {
                tabla.add(new Recept(
                        ered.getInt("receptid"),
                        ered.getString("nev"),
                        ered.getString("kategoria"),
                        ered.getString("leiras1"),
                        ered.getString("leiras2"),
                        ered.getString("alkoto")
                ));
            }
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }

    public void kedvencekbeolvas(ObservableList<Kedvenc> tabla, String alkoto) {
        String s = "select recept.nev, recept.receptid, recept.kategoria, recept.leiras1, recept.leiras2, recept.alkoto, kedvencek.receptid,kedvencek.kedvenc,kedvencek.fhNev "
                + "from kedvencek join recept on recept.receptid=kedvencek.receptid where  kedvencek.kedvenc=true AND kedvencek.fhNev=? ; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            tabla.clear();
            ekp.setString(1, alkoto);
            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {
                tabla.add(new Kedvenc(
                        ered.getInt("recept.receptid"),
                        ered.getString("recept.nev"),
                        ered.getString("recept.kategoria"),
                        ered.getString("recept.leiras1"),
                        ered.getString("recept.leiras2"),
                        ered.getString("recept.alkoto"),
                        ered.getInt("kedvencek.receptid"),
                        ered.getString("kedvencek.fhNEV"),
                        ered.getBoolean("kedvencek.kedvenc")
                ));
            }
        } catch (Exception e) {panel.Panel.hiba(
                "Hiba!", e.getMessage());
        }
    }

    public boolean kmegszamolvane(int receptid, String fhNEV) {
        String s = "SELECT COUNT(receptid) AS Darab FROM kedvencek WHERE receptid=? AND fhNev=? ; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            int vane = 0;
            ekp.setInt(1, receptid);
            ekp.setString(2, fhNEV);
            ResultSet ered = ekp.executeQuery();
            while (ered.next()) {
                vane = ered.getInt("Darab");
            }
            return vane > 0;
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", "Rossz DB!");
            return true;
        }
    }

    public int ktorlo(int receptid) {
        String s = "DELETE FROM kedvencek where receptid=?; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setInt(1, receptid);
            return ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return 0;
        }
    }

    public int kletrehozo(int receptid, boolean kedvenc, String fhNEV) {
        String s = "insert into kedvencek (receptid,kedvenc,fhNev) values (?,?,?); ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setInt(1, receptid);
            ekp.setString(3, fhNEV);
            ekp.setInt(2, 1);
            return ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return 0;
        }
    }

    public int fioktorles(String fhNEV) {

        String s = "delete from felhasznalok where fhNEV=?; ";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {

            ekp.setString(1, fhNEV);
            return ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
            return 0;
        }
    }

    public void f1(String fhNEVm, String fhNEV) {
        String s = "UPDATE felhasznalok SET fhNEV=? WHERE fhNEV=?";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, fhNEVm);
            ekp.setString(2, fhNEV);
            ekp.executeUpdate();
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }

    public void f2(String fhJelszom, String fhJelszo) {
        String s = "UPDATE felhasznalok SET fhJelszo=? WHERE fhNEV=?";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, fhJelszom);
            ekp.setString(2, fhJelszo);
            ekp.executeUpdate();

        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }

    public void f3(String fhemailm, String fhEmail) {
        String s = "UPDATE felhasznalok SET fhEmail=? WHERE fhNEV=?";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, fhemailm);
            ekp.setString(2, fhEmail);
            ekp.executeUpdate();

        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }

    public String[] feltolt(String fhNEV) {
        String s = "SELECT fhNEV,fhEmail FROM felhasznalok WHERE fhNEV=?; ";
        String tomb[] = {"", ""};

        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {

            ekp.setString(1, fhNEV);
            ResultSet ered = ekp.executeQuery();
            ered.next();
            tomb[0] = ered.getString("fhNEV");
            tomb[1] = ered.getString("fhEmail");
            return tomb;
        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", "Rossz DB");
        }
        return tomb;
    }
    public void receptbenalkotoatiras(String fhNevvaltozik, String fhNev){
        String s = "UPDATE recept SET alkoto=? WHERE alkoto=?";
        try (Connection kapcs = DriverManager.getConnection(db, user, pass);
                PreparedStatement ekp = kapcs.prepareStatement(s)) {
            ekp.setString(1, fhNevvaltozik);
            ekp.setString(2, fhNev);
            ekp.executeUpdate();

        } catch (Exception e) {
            panel.Panel.hiba("Hiba!", e.getMessage());
        }
    }
}
