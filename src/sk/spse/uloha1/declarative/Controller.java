package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField celsiusField;

    @FXML
    private TextField fahrenheitField;

    @FXML
    private void handleCelsiusInput() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = celsius * 9 / 5 + 32;
            // Zaokrúhlenie na 1 desatinné miesto
            fahrenheitField.setText(String.format("%.1f", fahrenheit).replace(",", "."));
        } catch (NumberFormatException e) {
            fahrenheitField.setText("");
        }
    }

    @FXML
    private void handleFahrenheitInput() {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            celsiusField.setText(String.format("%.1f", celsius).replace(",", "."));
        } catch (NumberFormatException e) {
            celsiusField.setText("");
        }
    }
}