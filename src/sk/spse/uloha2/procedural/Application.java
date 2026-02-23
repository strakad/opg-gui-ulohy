package sk.spse.uloha2.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {

        // Layout
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        // Meno
        Label menoLabel = new Label("Užívateľské meno:");
        TextField menoField = new TextField();

        // Heslo
        Label hesloLabel = new Label("Heslo:");
        PasswordField hesloField = new PasswordField();

        // Pohlavie
        Label pohlavieLabel = new Label("Pohlavie:");

        ToggleGroup group = new ToggleGroup();
        RadioButton muz = new RadioButton("Muž");
        RadioButton zena = new RadioButton("Žena");

        muz.setToggleGroup(group);
        zena.setToggleGroup(group);
        muz.setSelected(true);

        HBox pohlavieBox = new HBox(15, muz, zena);

        // Tlačidlá
        Button registrujBtn = new Button("Registrovať");
        Button zatvorBtn = new Button("Zavrieť");

        HBox buttonBox = new HBox(15, registrujBtn, zatvorBtn);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        // Akcia registrovať
        registrujBtn.setOnAction(e -> {

            if (menoField.getText().isEmpty() || hesloField.getText().isEmpty()) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("Chyba");
                error.setContentText("Vyplň všetky polia!");
                error.showAndWait();
                return;
            }

            RadioButton selected = (RadioButton) group.getSelectedToggle();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registrácia");
            alert.setHeaderText("Registrácia prebehla úspešne");

            String message = String.format(
                    "Užívateľ %s (%s) s heslom %s bol pridaný do systému",
                    menoField.getText(),
                    selected.getText(),
                    hesloField.getText()
            );

            alert.setContentText(message);
            alert.showAndWait();
        });

        // Akcia zatvor
        zatvorBtn.setOnAction(e -> Platform.exit());

        // Pridanie do GridPane
        root.add(menoLabel, 0, 0);
        root.add(menoField, 1, 0);

        root.add(hesloLabel, 0, 1);
        root.add(hesloField, 1, 1);

        root.add(pohlavieLabel, 0, 2);
        root.add(pohlavieBox, 1, 2);

        root.add(buttonBox, 1, 3);

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("Procedural Application 2");
        stage.setScene(scene);
        stage.show();
    }
}