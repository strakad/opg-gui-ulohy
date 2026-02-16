package sk.spse.uloha1.procedural;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {

        // ===== Celsius =====
        Label celsiusLabel = new Label("Celsius:");
        TextField celsiusField = new TextField();

        HBox celsiusBox = new HBox(10, celsiusLabel, celsiusField);

        // ===== Fahrenheit =====
        Label fahrenheitLabel = new Label("Fahrenheit:");
        TextField fahrenheitField = new TextField();

        HBox fahrenheitBox = new HBox(10, fahrenheitLabel, fahrenheitField);

        // ===== Logika prepočtu =====
        celsiusField.setOnKeyTyped(e -> {
            try {
                double c = Double.parseDouble(celsiusField.getText());
                double f = (c * 9 / 5) + 32;
                fahrenheitField.setText(String.format("%.1f", f));
            } catch (Exception ex) {
                fahrenheitField.clear();
            }
        });

        fahrenheitField.setOnKeyTyped(e -> {
            try {
                double f = Double.parseDouble(fahrenheitField.getText());
                double c = (f - 32) * 5 / 9;
                celsiusField.setText(String.format("%.1f", c));
            } catch (Exception ex) {
                celsiusField.clear();
            }
        });

        // ===== Root layout =====
        VBox root = new VBox(15, celsiusBox, fahrenheitBox);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root);

        stage.setTitle("Procedural Application 2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
