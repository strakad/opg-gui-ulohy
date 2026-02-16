package sk.spse.uloha2.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    private int counter = 0;

    @FXML
    private TextField counterField;
    private TextField textField;

    @FXML
    private void incrementCounter() {
        counter++;
        counterField.setText(String.valueOf(counter));
    }
}
