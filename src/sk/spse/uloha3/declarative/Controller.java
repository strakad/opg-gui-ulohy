package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    @FXML
    private void closeApplication() {
        // Ukončí program
        Platform.exit();
    }
}