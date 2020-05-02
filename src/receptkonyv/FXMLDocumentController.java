package receptkonyv;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 *
 * @author Tőth krisztián
 */
public class FXMLDocumentController implements Initializable {

    DB ab = new DB();

    private boolean profil = true;
    private boolean modosit = true;
    private boolean hozzaad;
    private boolean leüt = true;
    private boolean koppint = true;
    private boolean megnyom = true;
    char[] betuk = {};

    @FXML
    private Pane fopane;

    @FXML
    private AnchorPane bellsoancorpaneegy;

    @FXML
    private HBox lbevagyrhbox;

    @FXML
    private PasswordField bejelentkezesbe;

    @FXML
    private TextArea ahozzavalokszovegearea;

    @FXML
    private ScrollPane scrollpane1recept;

    @FXML
    private TextArea areceptszovegearea;

    @FXML
    private TextField txtfelhasznalonevre;

    @FXML
    private AnchorPane bellsoancorpaneketto;

    @FXML
    private AnchorPane regisztracioancorpane;

    @FXML
    private AnchorPane belepesancorpane;

    @FXML
    private TextField txtfelhasznalobe;

    @FXML
    private TextField txtkeres;

    @FXML
    private TextField ujreceptnev;

    @FXML
    private AnchorPane scrollpaneancorpane2;

    @FXML
    private AnchorPane scrollpaneancorpane1;

    @FXML
    private PasswordField jelszore;

    @FXML
    private PasswordField jelszoujrare;

    @FXML
    private ImageView receptkepeimg;

    @FXML
    private TextField txtemailcimre;

    @FXML
    private TextField ujkategoria;

    @FXML
    private TableView<Recept> tbllista;

    @FXML
    private TableColumn<Recept, Integer> tablecrceptid;

    @FXML
    private TableColumn<Recept, String> tablecreceptnev;

    @FXML
    private TableColumn<Recept, String> tableckategoria;

    @FXML
    private TableColumn<Recept, String> tablecalkotoja;
    
    @FXML
    private Button xgombid;

    @FXML
    private Label lblfhnev;

    @FXML
    private Button receptekgombid;

    @FXML
    private Button sajatreceptekgombid;

    @FXML
    private Button receptmodositasagombid;

    @FXML
    private Label receptnevfelirat;

    @FXML
    private Label kategoriafelirat;

    @FXML
    private Label hozzavalokfelirat;

    @FXML
    private Label receptszovegfelirat;

    @FXML
    private Button ujreceptgombid;

    @FXML
    private TableView<Recept> tbllista1;

    @FXML
    private TableColumn<Recept, Integer> tablecrceptid1;

    @FXML
    private TableColumn<Recept, String> tablecreceptnev1;

    @FXML
    private TableColumn<Recept, String> tableckategoria1;

    @FXML
    private TableColumn<Recept, String> tablecalkotoja1;

    @FXML
    private TableView<Kedvenc> tbllista2;

    @FXML
    private TableColumn<Kedvenc, Integer> tablecrceptid2;

    @FXML
    private TableColumn<Kedvenc, String> tablecreceptnev2;

    @FXML
    private TableColumn<Kedvenc, String> tableckategoria2;

    @FXML
    private TableColumn<Kedvenc, String> tablecalkotoja2;

    @FXML
    private Button kimasolgomb;

    @FXML
    private CheckBox kedvid;

    @FXML
    private Button kedvencekgombid;

    @FXML
    private Button visszagombid;

    @FXML
    private Button kimasolgombid;

    @FXML
    private ScrollPane scrollpane2felhasznaloiadatok;

    @FXML
    private TextField felhkapcsolat;

    @FXML
    private TextField emailkapcsolat;

    @FXML
    private Button profilgombid;

    @FXML
    private Button recepttorlesegombid;

    @FXML
    private Button sugogombid;

    @FXML
    private Button keresestorlesegombid;

    @FXML
    private Button kapcsolatgombid;

    @FXML
    private TextField felhkapcsolat1;

    @FXML
    private TextField jelszokapcsolat1;

    @FXML
    private TextField emailkapcsolat1;

    @FXML
    private Button kilepesgombid;

    @FXML
    private Button exporid;

    @FXML
    public void felhasznaloifioktorlese() {

        String felhasznalo = lblfhnev.getText();
        if (panel.Panel.igennem("Törlés", "Biztosan törölni szeretéd a fiókodat?")) {
            ab.fioktorles(felhasznalo);
            profil = true;
            kilepesgomb();
        } else {
            return;
        }

    }

    @FXML
    public void kapcsolatgomb() {
        panel.Panel.kapcsolat("Kapcsolat!",
                "\n" + "Szakdolgozat  " + "\n"
                + "\nEz a program egy szakdolgozat, "
                + "amely az 5421305 számú Szoftverfejlesztő szakképzés záróvizsgájára készült."
                + "\n\n\n"
                + "Célkitűzés  "
                + "\n\n"
                + "A szakdolgozatom célja egy recepteke tárolására és használatára alkalmas program elkészítésére. A felület célja, hogy a felhasználó álltal betáplált adatokat egy adatbázisban tárolja el, és a felhasználó álltal kiválasztott lehetőségek alapján táblázatban jelenítse meg. A platformnak a feladata, hogy a felhasználó receptjeit befogadja és adattáblákba rendezze. És később olvasás céljából kinyerje az adatokat az adattáblákból és megjelenítse. Az adatbázisnak biztosítania kell az egyéni adatok biztonságos tárolását. A felhasználónak szüksége lehet a receptek esetleges módosítására vagy törlésére, amit biztosítania kell a programnak. A felhasználó saját fiókkal rendelkezi, ezáltal bevitt adatait külön is képes hasznosítani. "
                + "\n\n"
                + "Készítette: Tóth Krisztián"
                + "\n\n"
                + "Konzulens: Tóth József");
    }

    private void kattinthatosag(boolean f) {
        receptekgombid.setDisable(f);
        sajatreceptekgombid.setDisable(f);
        kedvencekgombid.setDisable(f);
        receptmodositasagombid.setDisable(f);
        recepttorlesegombid.setDisable(f);
        ujreceptgombid.setDisable(f);
        sugogombid.setDisable(f);
        keresestorlesegombid.setDisable(f);
        txtkeres.setDisable(f);
        kilepesgombid.setDisable(f);
    }

    @FXML
    public void profilgomb() {
        if (profil) {
            tbllista.setVisible(false);
            tbllista1.setVisible(false);
            tbllista2.setVisible(false);
            scrollpane1recept.setVisible(false);
            scrollpane2felhasznaloiadatok.setVisible(true);
            kattinthatosag(profil);
            String tomb[] = ab.feltolt(lblfhnev.getText());
            felhkapcsolat.setText(tomb[0]);
            emailkapcsolat.setText(tomb[1]);
            felhkapcsolat.setEditable(false);
            emailkapcsolat.setEditable(false);
            profil = false;
            profilgombid.setText("Vissza  ");
        } else {
            kattinthatosag(profil);
            scrollpane2felhasznaloiadatok.setVisible(false);
            tbllista.setVisible(true);
            beolvas();
            profilgombid.setText("Profil  ");
            profil = true;

        }
    }

    @FXML
    public void regisztraciosoldalgomb() {
        xgombid.setVisible(true);
        regisztracioancorpane.setVisible(true);
        lbevagyrhbox.setVisible(false);
        belepesancorpane.setVisible(false);
        bellsoancorpaneketto.setVisible(false);
    }

    @FXML
    public void belepesoldalgomb() {
        xgombid.setVisible(true);
        belepesancorpane.setVisible(true);
        lbevagyrhbox.setVisible(false);
        regisztracioancorpane.setVisible(false);
        bellsoancorpaneketto.setVisible(false);
    }

    @FXML
    public void regisztraciogomb() {
        String txtfelhasznalonevre = this.txtfelhasznalonevre.getText();
        String txtemailcimre = this.txtemailcimre.getText();
        String txtjelszore = this.jelszore.getText();
        String txtjelszujrare = this.jelszoujrare.getText();

        if ("".equals(txtfelhasznalonevre) || "".equals(txtemailcimre) || "".equals(txtjelszore) || "".equals(txtjelszujrare)) {
            panel.Panel.hiba("Hiba!", "Kihagytál egy mezőt!");

        } else if (!txtjelszore.equals(txtjelszujrare)) {
            panel.Panel.hiba("Hiba!", "Az egyik jelszót rosszul adtad meg!");

        } else if (ab.felhasznalonevvizsgalat(txtfelhasznalonevre)) {
            panel.Panel.hiba("Hiba!", "Már létezik ilyen nevű felhasználó!");
        } else if (txtfelhasznalonevre.length() < 5) {
            panel.Panel.hiba("Hiba!", "A felhasználónévnek minimum 5 karakter hosszúnak kell lennie!");

        } else if (txtfelhasznalonevre.length() > 40) {
            panel.Panel.hiba("Hiba!", "A felhasználónévnek maximum 40 karakter hosszúnak kell lennie!");

        } else if (txtjelszore.length() < 5 && txtjelszujrare.length() < 5) {
            panel.Panel.hiba("Hiba!", "A jelszónak minimum 5 karakter hosszúnak kell lennie!");

        } else {
            ab.felhasznalohozzaad(txtfelhasznalonevre, txtemailcimre, txtjelszore);
            scrollpane2felhasznaloiadatok.setVisible(false);
            bellsoancorpaneketto.setVisible(true);
            bellsoancorpaneegy.setVisible(false);
            scrollpane1recept.setVisible(false);
            tbllista.setVisible(false);
            tbllista1.setVisible(false);
            tbllista2.setVisible(false);
            kedvid.setVisible(false);
            lblfhnev.setText(txtfelhasznalonevre);
            txtkeres.requestFocus();
            this.txtfelhasznalonevre.clear();
            this.txtemailcimre.clear();
            this.jelszore.clear();
            this.jelszoujrare.clear();

        }

    }

    @FXML
    public void belepesgomb() {
        String txtfelhasznalobe = this.txtfelhasznalobe.getText();
        String txtbelepesbe = this.bejelentkezesbe.getText();

        if ("".equals(txtfelhasznalobe) || "".equals(txtbelepesbe)) {
            panel.Panel.hiba("Hiba!", "Kihagytál egy mezőt!");

        } else if (!ab.felhasznalonevvizsgalat(txtfelhasznalobe)) {
            panel.Panel.hiba("Hiba!", "Nincs ilyen nevű felhasználó!");
        } else if (!ab.jelszovizsgalat(txtfelhasznalobe).equals(txtbelepesbe)) {
            panel.Panel.hiba("Hiba!", "Rossz jelszó!");
        } else {
            scrollpane2felhasznaloiadatok.setVisible(false);
            bellsoancorpaneketto.setVisible(true);
            bellsoancorpaneegy.setVisible(false);
            tbllista.setVisible(false);
            tbllista1.setVisible(false);
            tbllista2.setVisible(false);
            scrollpane1recept.setVisible(false);
            kedvid.setVisible(false);
            lblfhnev.setText(txtfelhasznalobe);
            txtkeres.requestFocus();
            this.txtfelhasznalobe.clear();
            this.bejelentkezesbe.clear();
        }

    }

    @FXML
    public void xgomb() {
        lbevagyrhbox.setVisible(true);
        regisztracioancorpane.setVisible(false);
        belepesancorpane.setVisible(false);
        xgombid.setVisible(false);

        txtfelhasznalonevre.clear();
        txtemailcimre.clear();
        jelszore.clear();
        jelszoujrare.clear();
        txtfelhasznalobe.clear();
        bejelentkezesbe.clear();
    }

    @FXML
    public void visszagomb() {
        hozzaad = false;
        ujreceptgombid.setText("Új recept");
        exporid.setDisable(false);
        sajatreceptekgombid.setDisable(false);
        receptekgombid.setDisable(false);
        kedvencekgombid.setDisable(false);
        receptmodositasagombid.setDisable(false);
        recepttorlesegombid.setDisable(false);

        visszagombid.setVisible(false);
        scrollpane1recept.setVisible(false);
        tbllista.setVisible(true);
        kedvid.setVisible(false);
        profilgombid.setDisable(false);
        kilepesgombid.setDisable(false);
        beolvas();
        sajatbeolvas();
        kedvencekbeolvas();
        receptekgomb();

    }

    @FXML
    public void keresestorlesegomb() {
        txtkeres.clear();

    }

    private void szerkeszthetoseg(boolean igaze) {
        ujreceptnev.setEditable(igaze);
        ujkategoria.setEditable(igaze);
        ahozzavalokszovegearea.setEditable(igaze);
        areceptszovegearea.setEditable(igaze);

    }

    private int figyelo() {
        int index = tbllista.getSelectionModel().getSelectedIndex();
        return index;
    }

    private int figyelo1() {
        int index1 = tbllista1.getSelectionModel().getSelectedIndex();
        return index1;
    }

    private int figyelo2() {
        int index2 = tbllista2.getSelectionModel().getSelectedIndex();
        return index2;
    }

    @FXML
    public void receptekgomb() {
        if (megnyom) {
            if (figyelo() > -1) {
                int receptid = tbllista.getItems().get(figyelo()).getReceptid();
                String lblfhnev = this.lblfhnev.getText();
                boolean kedvid = this.kedvid.isSelected();

                if (kedvid) {
                    if (!ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.kletrehozo(receptid, kedvid, lblfhnev);
                    }
                }
                if (!kedvid) {
                    if (ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.ktorlo(receptid);
                    }
                }

            }
            sajatreceptekgombid.setText("Saját receptek  ");
            koppint = true;
            beolvas();
            kedvencekgombid.setText("Kedvencek  ");
            leüt = true;

            scrollpane1recept.setVisible(false);
            tbllista1.setVisible(false);
            tbllista.setVisible(true);
            kimasolgombid.setVisible(false);
            tbllista2.setVisible(false);
            megnyom = false;
            receptekgombid.setText("Megnyitás  ");

            szerkeszthetoseg(true);
            this.kedvid.setVisible(false);
        } else {
            if (figyelo() > -1) {
                int receptid = tbllista.getItems().get(figyelo()).getReceptid();
                String lblfhnev = this.lblfhnev.getText();
                boolean kedvid = this.kedvid.isSelected();
                if (!ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(false);
                }

                if (ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(true);
                }

                szerkeszthetoseg(false);

                tbllista.setVisible(false);
                tbllista1.setVisible(false);
                tbllista2.setVisible(false);
                kimasolgombid.setVisible(true);
                scrollpane1recept.setVisible(true);
                receptekgombid.setText("Receptek  ");
                megnyom = true;
                this.kedvid.setVisible(true);
            }

        }

    }

    @FXML
    public void sajatreceptekgomb() {

        if (koppint) {
            if (figyelo1() > -1) {
                int receptid = tbllista1.getItems().get(figyelo1()).getReceptid();
                String lblfhnev = this.lblfhnev.getText();
                boolean kedvid = this.kedvid.isSelected();

                if (kedvid) {
                    if (!ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.kletrehozo(receptid, kedvid, lblfhnev);
                    }
                }
                if (!kedvid) {
                    if (ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.ktorlo(receptid);
                    }
                }

            }
            receptekgombid.setText("Receptek  ");
            megnyom = true;
            kedvencekgombid.setText("Kedvencek  ");
            leüt = true;
            sajatbeolvas();
            scrollpane1recept.setVisible(false);
            tbllista.setVisible(false);
            tbllista2.setVisible(false);
            kimasolgombid.setVisible(false);
            tbllista1.setVisible(true);
            koppint = false;
            kedvid.setVisible(false);
            sajatreceptekgombid.setText("Megnyitás  ");
            szerkeszthetoseg(true);
        } else {

            if (figyelo1() > -1) {
                int receptid = tbllista1.getItems().get(figyelo1()).getReceptid();
                String lblfhnev = this.lblfhnev.getText();
                boolean kedvid = this.kedvid.isSelected();
                if (!ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(false);
                }

                if (ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(true);
                }
                szerkeszthetoseg(false);
                tbllista.setVisible(false);
                tbllista1.setVisible(false);
                tbllista2.setVisible(false);
                kimasolgombid.setVisible(true);
                scrollpane1recept.setVisible(true);
                sajatreceptekgombid.setText("Saját receptek  ");
                koppint = true;
                this.kedvid.setVisible(true);

            }
        }

    }
    @FXML
    public void kedvencekgombid() {
        if (leüt) {
            if (figyelo2() > -1) {
                int receptid = tbllista2.getItems().get(figyelo2()).getReceptid();
                String lblfhnev = this.lblfhnev.getText();
                boolean kedvid = this.kedvid.isSelected();

                if (kedvid) {
                    if (!ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.kletrehozo(receptid, kedvid, lblfhnev);
                    }
                }
                if (!kedvid) {
                    if (ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.ktorlo(receptid);
                    }
                }

            }
            receptekgombid.setText("Receptek  ");
            megnyom = true;
            sajatreceptekgombid.setText("Saját receptek  ");
            koppint = true;
            kedvencekbeolvas();
            scrollpane1recept.setVisible(false);
            tbllista1.setVisible(false);
            tbllista.setVisible(false);
            kimasolgombid.setVisible(false);
            tbllista2.setVisible(true);
            leüt = false;
            kedvencekgombid.setText("Megnyitás  ");
            kedvid.setVisible(false);
            szerkeszthetoseg(true);
        } else {

            if (figyelo2() > -1) {
                int receptid = tbllista2.getItems().get(figyelo2()).getReceptid();
                String lblfhnev = this.lblfhnev.getText();
                boolean kedvid = this.kedvid.isSelected();
                if (!ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(false);
                }

                if (ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(true);
                }
                szerkeszthetoseg(false);
                tbllista.setVisible(false);
                tbllista1.setVisible(false);
                tbllista2.setVisible(false);
                kimasolgombid.setVisible(true);
                scrollpane1recept.setVisible(true);
                kedvencekgombid.setText("Kedvencek  ");
                leüt = true;
                this.kedvid.setVisible(true);

            }

        }
    }

    @FXML
    public void sugogomb() throws URISyntaxException, IOException {
        URI u = new URI("http://127.0.0.1/sugo/sugo.html");
        if (Desktop.isDesktopSupported()) {
            Desktop d = Desktop.getDesktop();
            if (d.isSupported(Desktop.Action.BROWSE)) {
                d.browse(u);
            }
        }
    }

    @FXML
    public void kilepesgomb() {
        receptekgomb();
        sajatreceptekgomb();
        kedvencekgombid();
        bellsoancorpaneegy.setVisible(true);
        lbevagyrhbox.setVisible(true);
        regisztracioancorpane.setVisible(false);
        belepesancorpane.setVisible(false);
        bellsoancorpaneketto.setVisible(false);
        xgombid.setVisible(false);
        txtkeres.clear();

    }

    private void felirat(boolean igaze) {
        receptnevfelirat.setVisible(igaze);
        kategoriafelirat.setVisible(igaze);
        hozzavalokfelirat.setVisible(igaze);
        receptszovegfelirat.setVisible(igaze);
    }

    @FXML
    public void ujreceptgomb() {

        if (!hozzaad) {
            ujreceptnev.clear();
            ahozzavalokszovegearea.clear();
            areceptszovegearea.clear();
            ujkategoria.clear();
            tbllista.getSelectionModel().select(null);
            ujreceptnev.requestFocus();
            ujreceptgombid.setText("Hozzáad");
            hozzaad = true;
            sajatreceptekgombid.setDisable(true);
            receptekgombid.setDisable(true);
            kedvencekgombid.setDisable(true);
            receptmodositasagombid.setDisable(true);
            recepttorlesegombid.setDisable(true);
            exporid.setDisable(true);
            profilgombid.setDisable(true);
            kilepesgombid.setDisable(true);
            tbllista.setVisible(false);
            tbllista1.setVisible(false);
            tbllista2.setVisible(false);
            felirat(true);
            this.kedvid.setVisible(true);

            scrollpane1recept.setVisible(true);
            visszagombid.setVisible(true);
            

        } else {

            int receptid = ab.receptidlekerdezo() + 1;
            String ujreceptnev = this.ujreceptnev.getText();
            String ahozzavalokszovegearea = this.ahozzavalokszovegearea.getText();
            String areceptszovegearea = this.areceptszovegearea.getText();
            String lblfhnev = this.lblfhnev.getText();
            String ujkategoria = this.ujkategoria.getText();
            boolean kedvid = this.kedvid.isSelected();

            if ("".equals(ujreceptnev) || "".equals(ahozzavalokszovegearea) || "".equals(areceptszovegearea) || "".equals(ujkategoria)) {
                panel.Panel.hiba("Hiba!", "Kihagytál egy mezőt!");
            } else if (ab.nevvizsgalat(ujreceptnev)) {
                panel.Panel.hiba("Hiba!", "Már van ilyen nevű recept!");
            } else {
                ab.hozzaad(ujreceptnev, ujkategoria, ahozzavalokszovegearea, areceptszovegearea, lblfhnev);
                ujreceptgombid.setText("Új Recept");

                if (kedvid) {
                    if (!ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.kletrehozo(receptid, kedvid, lblfhnev);
                    }
                }
                if (!kedvid) {
                    if (ab.kmegszamolvane(receptid, lblfhnev)) {
                        ab.ktorlo(receptid);
                    }
                }
                hozzaad = false;

                sajatreceptekgombid.setDisable(false);
                receptekgombid.setDisable(false);
                kedvencekgombid.setDisable(false);
                receptmodositasagombid.setDisable(false);
                recepttorlesegombid.setDisable(false);
                exporid.setDisable(false);
                profilgombid.setDisable(false);
                kilepesgombid.setDisable(false);
                visszagombid.setVisible(false);
                scrollpane1recept.setVisible(false);
                tbllista1.setVisible(false);
                tbllista2.setVisible(false);
                tbllista.setVisible(true);
                this.kedvid.setVisible(false);

                beolvas();
            }
        }

    }

    private void modosit() {

        String nev = tbllista.getItems().get(figyelo()).getAlkoto();
        String felhasznalo = lblfhnev.getText();
        if (figyelo() == -1) {
            return;
        }
        if (figyelo() > -1 && nev.equals(felhasznalo)) {
            felirat(false);

            int receptid = tbllista.getItems().get(figyelo()).getReceptid();
            String ujreceptnev = this.ujreceptnev.getText();
            String ahozzavalokszovegearea = this.ahozzavalokszovegearea.getText();
            String areceptszovegearea = this.areceptszovegearea.getText();
            String lblfhnev = this.lblfhnev.getText();
            String ujkategoria = this.ujkategoria.getText();
            boolean kedvid = this.kedvid.isSelected();
            if (modosit) {
                receptekgombid.setDisable(true);
                sajatreceptekgombid.setDisable(true);
                kedvencekgombid.setDisable(true);
                exporid.setDisable(true);
                tbllista.setVisible(false);
                tbllista1.setVisible(false);
                tbllista2.setVisible(false);
                scrollpane1recept.setVisible(true);
                profilgombid.setDisable(true);
                kilepesgombid.setDisable(true);
                receptmodositasagombid.setText("Szerkesztés");
                modosit = false;
                this.kedvid.setVisible(true);
                 
                if (!ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(false);
                }

                if (ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(true);
                }
            } else {

                if ("".equals(ujreceptnev) || "".equals(ahozzavalokszovegearea) || "".equals(areceptszovegearea) || "".equals(ujkategoria)) {
                    panel.Panel.hiba("Hiba!", "Kihagytál egy mezőt!");

                } else {

                    int sor = ab.modosit(ujreceptnev, ujkategoria, ahozzavalokszovegearea, areceptszovegearea, receptid);

                    if (kedvid) {
                        if (!ab.kmegszamolvane(receptid, lblfhnev)) {
                            ab.kletrehozo(receptid, kedvid, lblfhnev);
                        }
                    }
                    if (!kedvid) {
                        if (ab.kmegszamolvane(receptid, lblfhnev)) {
                            ab.ktorlo(receptid);
                        }
                    }

                    beolvas();
                    sajatbeolvas();
                    kedvencekbeolvas();
                    if (sor > 0) {

                        receptekgomb();

                        receptmodositasagombid.setText("Módosít");

                        for (int i = 0; i < tbllista.getItems().size(); i++) {

                            if (tbllista.getItems().get(i).getReceptid() == receptid) {
                                tbllista.getSelectionModel().select(i);

                            }

                        }
                    }
                    modosit = true;
                    receptekgombid.setDisable(false);
                    sajatreceptekgombid.setDisable(false);
                    kedvencekgombid.setDisable(false);
                    exporid.setDisable(false);
                    profilgombid.setDisable(false);
                    kilepesgombid.setDisable(false);
                    scrollpane1recept.setVisible(false);
                    scrollpane1recept.setVisible(false);
                    tbllista.setVisible(true);
                    this.kedvid.setVisible(false);

                }

            }

        } else {
            panel.Panel.hiba("Törlés!", "Más felhasználó receptjeit nem módosíthatod!");
        }

    }

    private void modosit1() {
        String nev1 = tbllista1.getItems().get(figyelo1()).getAlkoto();
        String felhasznalo = lblfhnev.getText();
        if (figyelo1() == -1) {
            return;
        }
        if (figyelo1() > -1 && nev1.equals(felhasznalo)) {

            felirat(false);

            int receptid = tbllista1.getItems().get(figyelo1()).getReceptid();
            String ujreceptnev = this.ujreceptnev.getText();
            String ahozzavalokszovegearea = this.ahozzavalokszovegearea.getText();
            String areceptszovegearea = this.areceptszovegearea.getText();
            String lblfhnev = this.lblfhnev.getText();
            String ujkategoria = this.ujkategoria.getText();
            boolean kedvid = this.kedvid.isSelected();
            if (modosit) {
                receptekgombid.setDisable(true);
                sajatreceptekgombid.setDisable(true);
                kedvencekgombid.setDisable(true);
                exporid.setDisable(true);
                profilgombid.setDisable(true);
                kilepesgombid.setDisable(true);
                tbllista1.setVisible(false);
                tbllista.setVisible(false);
                tbllista2.setVisible(false);
                scrollpane1recept.setVisible(true);
                receptmodositasagombid.setText("Szerkesztés");
                modosit = false;
                this.kedvid.setVisible(true);
if (!ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(false);
                }

                if (ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(true);
                }
            } else {
                if ("".equals(ujreceptnev) || "".equals(ahozzavalokszovegearea) || "".equals(areceptszovegearea) || "".equals(ujkategoria)) {
                    panel.Panel.hiba("Hiba!", "Kihagytál egy mezőt!");

                } else {
                    int sor = ab.modosit(ujreceptnev, ujkategoria, ahozzavalokszovegearea, areceptszovegearea, receptid);
                    if (kedvid) {
                        if (!ab.kmegszamolvane(receptid, lblfhnev)) {
                            ab.kletrehozo(receptid, kedvid, lblfhnev);
                        }
                    }
                    if (!kedvid) {
                        if (ab.kmegszamolvane(receptid, lblfhnev)) {
                            ab.ktorlo(receptid);
                        }
                    }
                    beolvas();
                    sajatbeolvas();
                    kedvencekbeolvas();
                    if (sor > 0) {
                        sajatreceptekgomb();
                        sajatbeolvas();
                        receptmodositasagombid.setText("Módosít");
                        for (int i = 0; i < tbllista1.getItems().size(); i++) {

                            if (tbllista1.getItems().get(i).getReceptid() == receptid) {
                                tbllista1.getSelectionModel().select(i);

                            }
                        }
                    }
                    modosit = true;
                    receptekgombid.setDisable(false);
                    sajatreceptekgombid.setDisable(false);
                    kedvencekgombid.setDisable(false);
                    exporid.setDisable(false);
                    profilgombid.setDisable(false);
                    kilepesgombid.setDisable(false);
                    scrollpane1recept.setVisible(false);
                    scrollpane1recept.setVisible(false);
                    tbllista1.setVisible(true);
                    this.kedvid.setVisible(false);
                }

            }

        } else {
            panel.Panel.hiba("Törlés!", "Más felhasználó receptjeit nem módosíthatod!");
        }
    }

    private void modosit2() {
        String nev2 = tbllista2.getItems().get(figyelo2()).getAlkoto();
        String felhasznalo = lblfhnev.getText();
        if (figyelo2() == -1) {
            return;
        }
        if (figyelo2() > -1 && nev2.equals(felhasznalo)) {
            felirat(false);

            int receptid = tbllista2.getItems().get(figyelo2()).getReceptid();
            String ujreceptnev = this.ujreceptnev.getText();
            String ahozzavalokszovegearea = this.ahozzavalokszovegearea.getText();
            String areceptszovegearea = this.areceptszovegearea.getText();
            String lblfhnev = this.lblfhnev.getText();
            String ujkategoria = this.ujkategoria.getText();
            boolean kedvid = this.kedvid.isSelected();

            if (modosit) {

                receptekgombid.setDisable(true);
                sajatreceptekgombid.setDisable(true);
                kedvencekgombid.setDisable(true);
                exporid.setDisable(true);
                profilgombid.setDisable(true);
                kilepesgombid.setDisable(true);
                tbllista.setVisible(false);
                tbllista1.setVisible(false);
                tbllista2.setVisible(false);
                scrollpane1recept.setVisible(true);
                receptmodositasagombid.setText("Szerkesztés");
                modosit = false;
                this.kedvid.setVisible(true);
if (!ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(false);
                }

                if (ab.kmegszamolvane(receptid, lblfhnev)) {

                    this.kedvid.setSelected(true);
                }
            } else {

                if ("".equals(ujreceptnev) || "".equals(ahozzavalokszovegearea) || "".equals(areceptszovegearea) || "".equals(ujkategoria)) {
                    panel.Panel.hiba("Hiba!", "Kihagytál egy mezőt!");

                } else {

                    int sor = ab.modosit(ujreceptnev, ujkategoria, ahozzavalokszovegearea, areceptszovegearea, receptid);

                    if (kedvid) {
                        if (!ab.kmegszamolvane(receptid, lblfhnev)) {
                            ab.kletrehozo(receptid, kedvid, lblfhnev);
                        }
                    }
                    if (!kedvid) {
                        if (ab.kmegszamolvane(receptid, lblfhnev)) {
                            ab.ktorlo(receptid);
                        }
                    }

                    beolvas();
                    sajatbeolvas();
                    kedvencekbeolvas();
                    if (sor > 0) {
                        kedvencekgombid();
                        kedvencekbeolvas();

                        receptmodositasagombid.setText("Módosít");

                        for (int i = 0; i < tbllista2.getItems().size(); i++) {

                            if (tbllista2.getItems().get(i).getReceptid() == receptid) {
                                tbllista2.getSelectionModel().select(i);

                            }

                        }
                    }
                    modosit = true;
                    receptekgombid.setDisable(false);
                    sajatreceptekgombid.setDisable(false);
                    kedvencekgombid.setDisable(false);
                    exporid.setDisable(false);
                    profilgombid.setDisable(false);
                    kilepesgombid.setDisable(false);
                    scrollpane1recept.setVisible(false);
                    tbllista2.setVisible(true);
                    this.kedvid.setVisible(false);
                }

            }

        } else {
            panel.Panel.hiba("Törlés!", "Más felhasználó receptjeit nem módosíthatod!");
        }
    }

    @FXML
    public void receptmodositasagomb() {
        if (!megnyom) {
            modosit();
        }
        if (!koppint) {
            modosit1();
        }
        if (!leüt) {
            modosit2();
        }

    }

    private boolean recepttorlese() {
        String nev1 = tbllista.getItems().get(figyelo()).getAlkoto();
        String felhasznalo = lblfhnev.getText();
        if (felhasznalo.equals(nev1)) {
            if (figyelo() == -1) {
                return false;
            }
            if (!panel.Panel.igennem("Törlés", "Biztosan törölni szeretéd ezt a receptet?")) {
                return false;
            }
            int id = tbllista.getItems().get(figyelo()).getReceptid();
            int sor = ab.torol(id, nev1);
            ab.ktorlo(id);
            if (sor > 0) {
                beolvas();
                return true;
            }
        } else {
            panel.Panel.hiba("Törlés!", "Más felhasználó receptjeit nem törölheted!");
        }
        return false;
    }

    private boolean recepttorlese1() {
        String nev2 = tbllista1.getItems().get(figyelo1()).getAlkoto();
        String felhasznalo = lblfhnev.getText();
        if (felhasznalo.equals(nev2)) {
            if (figyelo1() == -1) {
                return false;
            }
            if (!panel.Panel.igennem("Törlés", "Biztosan törölni szeretéd ezt a receptet?")) {
                return false;
            }
            int id = tbllista1.getItems().get(figyelo1()).getReceptid();
            int sor = ab.torol(id, nev2);
            ab.ktorlo(id);
            if (sor > 0) {
                sajatbeolvas();
                return true;
            }
        } else {
            panel.Panel.hiba("Törlés!", "Más felhasználó receptjeit nem törölheted!");
        }
        return false;
    }

    private boolean recepttorlese2() {
        String nev3 = tbllista2.getItems().get(figyelo2()).getAlkoto();
        String felhasznalo = lblfhnev.getText();
        if (felhasznalo.equals(nev3)) {

            if (figyelo2() == -1) {
                return false;
            }
            if (!panel.Panel.igennem("Törlés", "Biztosan törölni szeretéd ezt a receptet?")) {
                return false;
            }
            int id = tbllista2.getItems().get(figyelo2()).getReceptid();
            int sor = ab.torol(id, nev3);
            ab.ktorlo(id);
            if (sor > 0) {
                kedvencekbeolvas();
                return true;
            }

        } else {
            panel.Panel.hiba("Törlés!", "Más felhasználó receptjeit nem törölheted!");
        }
        return false;
    }

    @FXML
    public void recepttorlesegomb() {
        if (!megnyom) {
            recepttorlese();
        }
        if (!koppint) {
            recepttorlese1();
        }
        if (!leüt) {
            recepttorlese2();
        }

    }

    @FXML
    public void kimasolgomb() {
        Clipboard cb = Clipboard.getSystemClipboard();
        ClipboardContent tartalom = new ClipboardContent();
        tartalom.putString("\n\n\n\n" + ujreceptnev.getText()
                + "\n\n" + "Kategória: " + "\n\n" + ujkategoria.getText()
                + "\n\n" + "Hozzávalók: " + "\n\n" + ahozzavalokszovegearea.getText()
                + "\n\n" + "Elkészítés: " + "\n\n" + areceptszovegearea.getText()
                + "\n\n");
        cb.setContent(tartalom);

    }

    private void beolvas() {
        ab.beolvas(tbllista.getItems());

    }

    private void sajatbeolvas() {
        ab.sajatok(tbllista1.getItems(), lblfhnev.getText());

    }

    private void kedvencekbeolvas() {

        ab.kedvencekbeolvas(tbllista2.getItems(), lblfhnev.getText());

    }

    private void keresem() {
        String keresett = txtkeres.getText();

        String sql;
        if (!megnyom) {
            sql = "select * from recept where nev like '%"
                    + keresett + "%' order by receptid; ";
            ab.keresem(tbllista.getItems(), sql);
        }
        if (!koppint) {
            sql = "SELECT * from recept WHERE alkoto='" + lblfhnev.getText() + "' AND nev LIKE '%" + keresett + "%' ;";

            ab.keresem(tbllista1.getItems(), sql);
        }
        if (!leüt) {
            sql = "SELECT * from kedvencek JOIN recept on recept.receptid=kedvencek.receptid WHERE recept.alkoto='"
                    + lblfhnev.getText() + "' and kedvencek.kedvenc=1 and recept.nev LIKE '%" + keresett + "%' ;";
            ab.kedvencekkeresem(tbllista2.getItems(), sql);
        }

    }

    private void tablabol(int i) {
        if (i == -1) {
            return;
        }
        if (figyelo() > -1) {
            Recept e = tbllista.getItems().get(i);
            ujreceptnev.setText("" + e.getNev());
            ujkategoria.setText("" + e.getKategoria());
            ahozzavalokszovegearea.setText("" + e.getLeiras1());
            areceptszovegearea.setText("" + e.getLeiras2());

        }

        if (figyelo1() > -1) {
            Recept e1 = tbllista1.getItems().get(i);
            ujreceptnev.setText("" + e1.getNev());
            ujkategoria.setText("" + e1.getKategoria());
            ahozzavalokszovegearea.setText("" + e1.getLeiras1());
            areceptszovegearea.setText("" + e1.getLeiras2());
        }

        if (figyelo2() > -1) {
            Kedvenc e2 = tbllista2.getItems().get(i);
            ujreceptnev.setText("" + e2.getNev());
            ujkategoria.setText("" + e2.getKategoria());
            ahozzavalokszovegearea.setText("" + e2.getLeiras1());
            areceptszovegearea.setText("" + e2.getLeiras2());
            kedvid.setSelected(e2.isKedvenc());
        }

    }

    @FXML
    public void felhasznalonevmodosit() {

        if (felhkapcsolat1.getText().length() < 5) {
            panel.Panel.hiba("Hiba!", "A felhasználónévnek minimum 5 karakternek kell lennie!");
        } else if (felhkapcsolat1.getText().length() > 40) {
            panel.Panel.hiba("Hiba!", "A felhasználónévnek maximum 40 karakternek kell lennie!");
        } else {
            ab.receptbenalkotoatiras(felhkapcsolat1.getText(), lblfhnev.getText());
            ab.f1(felhkapcsolat1.getText(), lblfhnev.getText());
            lblfhnev.setText(felhkapcsolat1.getText());
            String tomb[] = ab.feltolt(lblfhnev.getText());
            felhkapcsolat.setText(tomb[0]);
            emailkapcsolat.setText(tomb[1]);
            panel.Panel.informacio("A Változtatás!", "A felhasználónév sikeresen megváltozott!");
        }
        felhkapcsolat1.setText("");
    }

    @FXML
    public void jelszomodosit() {
        if (jelszokapcsolat1.getText().length() < 5) {
            panel.Panel.hiba("Hiba!", "A jelszónak legalább 5 karakternek kell lennie!");
        } else {
            ab.f2(jelszokapcsolat1.getText(), lblfhnev.getText());
            panel.Panel.informacio("A Változtatás!", "A jelszó sikeresen megváltozott!");
        }
        jelszokapcsolat1.setText("");
    }

    @FXML
    public void emailmodosit() {
        ab.f3(emailkapcsolat1.getText(), lblfhnev.getText());
        String tomb[] = ab.feltolt(lblfhnev.getText());
        felhkapcsolat.setText(tomb[0]);
        emailkapcsolat.setText(tomb[1]);
        panel.Panel.informacio("A Változtatás!", "Az e-mailcím sikeresen megváltozott!");
        emailkapcsolat1.setText("");
    }

    private String txt1(int index) {
        String kikuldes = "                                         ";
        kikuldes += tbllista.getItems().get(index).getNev() + "\n\nHozzávalók: "
                + tbllista.getItems().get(index).getLeiras1() + "\n\nElkészítés: "
                + tbllista.getItems().get(index).getLeiras2() + "\n\n"
                + "Recept alkotója: "
                + tbllista.getItems().get(index).getAlkoto() + "\n\n";

        return kikuldes;
    }

    private String txt2(int index) {
        String kikuldes = "                                         ";
        kikuldes += tbllista1.getItems().get(index).getNev() + "\n\nHozzávalók: "
                + tbllista1.getItems().get(index).getLeiras1() + "\n\nElkészítés: "
                + tbllista1.getItems().get(index).getLeiras2() + "\n\n"
                + "Recept alkotója: "
                + tbllista1.getItems().get(index).getAlkoto() + "\n\n";
        return kikuldes;
    }

    private String txt3(int index) {
        String kikuldes = "                                         ";
        kikuldes += tbllista2.getItems().get(index).getNev() + "\n\nHozzávalók: "
                + tbllista2.getItems().get(index).getLeiras1() + "\n\nElkészítés: "
                + tbllista2.getItems().get(index).getLeiras2() + "\n\n"
                + "Recept alkotója: "
                + tbllista2.getItems().get(index).getAlkoto() + "\n\n";
        return kikuldes;
    }

    @FXML
    public void export() {

        FileChooser fc = new FileChooser();
        fc.setTitle("Exportálás");
        FileChooser.ExtensionFilter txt = new FileChooser.ExtensionFilter("txt fájl", "*.txt");
        fc.getExtensionFilters().add(txt);
        FileChooser.ExtensionFilter doc = new FileChooser.ExtensionFilter("doc fájl", "*.doc");
        fc.getExtensionFilters().add(doc);
        fc.setInitialDirectory(new File("."));
        File d = fc.showSaveDialog(null);
        if (d != null) {

            try (PrintWriter ir = new PrintWriter(d.getAbsoluteFile(), "UTF8")) {

                if (figyelo() > -1) {
                    ir.println(txt1(figyelo()));
                }
                if (figyelo1() > -1) {
                    ir.println(txt2(figyelo1()));
                }
                if (figyelo2() > -1) {
                    ir.println(txt3(figyelo2()));
                }

            } catch (IOException ex) {
                panel.Panel.hiba("Hiba", "Nem tudtam exportálni!");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablecrceptid.setCellValueFactory(new PropertyValueFactory<>("receptid"));
        tablecreceptnev.setCellValueFactory(new PropertyValueFactory<>("nev"));
        tableckategoria.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        tablecalkotoja.setCellValueFactory(new PropertyValueFactory<>("alkoto"));
        beolvas();

        tablecrceptid1.setCellValueFactory(new PropertyValueFactory<>("receptid"));
        tablecreceptnev1.setCellValueFactory(new PropertyValueFactory<>("nev"));
        tableckategoria1.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        tablecalkotoja1.setCellValueFactory(new PropertyValueFactory<>("alkoto"));
        sajatbeolvas();

        tablecrceptid2.setCellValueFactory(new PropertyValueFactory<>("receptid"));
        tablecreceptnev2.setCellValueFactory(new PropertyValueFactory<>("nev"));
        tableckategoria2.setCellValueFactory(new PropertyValueFactory<>("kategoria"));
        tablecalkotoja2.setCellValueFactory(new PropertyValueFactory<>("alkoto"));
        kedvencekbeolvas();

        tbllista.getSelectionModel().selectedIndexProperty().addListener((o, regi, uj) -> tablabol(uj.intValue()));
        tbllista1.getSelectionModel().selectedIndexProperty().addListener((o, regi, uj) -> tablabol(uj.intValue()));
        tbllista2.getSelectionModel().selectedIndexProperty().addListener((o, regi, uj) -> tablabol(uj.intValue()));
        txtkeres.textProperty().addListener((o, regi, ne) -> keresem());
    }

}
