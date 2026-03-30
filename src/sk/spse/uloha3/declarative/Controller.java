package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {
    public ImageView obrazok;
    public Slider slider;

    @FXML
    private void closeApplication() {
        Platform.exit();
    }
    public void rotuj(MouseEvent mouseEvent) {
        obrazok.setRotate(slider.getValue());
    }
}