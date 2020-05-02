package panel;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;


public class Panel {

    public static void hiba(String cim, String uzenet) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(cim);
        alert.setHeaderText(null);
        alert.setContentText(uzenet);
        alert.showAndWait();
    }

    public static boolean igennem(String cim, String uzenet) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(cim);
        alert.setHeaderText(null);
        alert.setContentText(uzenet);
        ButtonType btIgen = new ButtonType("Igen", ButtonData.NO);
        ButtonType btNem = new ButtonType("Nem", ButtonData.YES);
        alert.getButtonTypes().setAll( btNem, btIgen);
        return alert.showAndWait().get() == btIgen;
        
    }

    public static void kapcsolat(String cim, String uzenet) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(cim);
        alert.getDialogPane().getTransforms();
        alert.setX(650);
        alert.setY(200);
        alert.getDialogPane().setPrefSize(700, 630);
        alert.getDialogPane().setBackground(Background.EMPTY);
        alert.setHeaderText(null);
        alert.setContentText(uzenet);
        alert.showAndWait();
    }

    public static void informacio(String cim, String uzenet) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.getDialogPane().getTransforms();
        alert.setX(700);
        alert.setY(220);
        alert.getDialogPane().setPrefSize(400, 250);
        alert.getDialogPane().setBackground(Background.EMPTY);
        alert.setTitle(cim);
        alert.setHeaderText(null);
        alert.setContentText(uzenet);
        alert.showAndWait();
    }
}
