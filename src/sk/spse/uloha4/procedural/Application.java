package sk.spse.uloha4.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Random;

public class Application extends javafx.application.Application {

    private final Random random = new Random();

    @Override
    public void start(Stage stage) {

        VBox vbox1 = createBox("blue");
        VBox vbox2 = createBox("yellow");
        VBox vbox3 = createBox("green");
        VBox vbox4 = createBox("red");

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(4);

        // aby zabrali celú šírku
        tilePane.setPrefTileWidth(200);
        tilePane.setPrefTileHeight(250);

        tilePane.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);

        Label quote = new Label("\"In the future, everyone will be world-famous for 15 minutes\"");
        Label author = new Label("- Andy Warhol");

        VBox textBox = new VBox(quote, author);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button randomize = new Button("Randomize");
        Button close = new Button("Close");

        randomize.setOnAction(e -> {
            vbox1.setStyle("-fx-background-color: " + getRandomColor());
            vbox2.setStyle("-fx-background-color: " + getRandomColor());
            vbox3.setStyle("-fx-background-color: " + getRandomColor());
            vbox4.setStyle("-fx-background-color: " + getRandomColor());
        });

        close.setOnAction(e -> Platform.exit());

        HBox bottom = new HBox(20, textBox, spacer, randomize, close);
        bottom.setAlignment(Pos.CENTER_LEFT);
        bottom.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setCenter(tilePane);
        root.setBottom(bottom);

        Scene scene = new Scene(root, 800, 400);

        stage.setTitle("Procedural Application 4");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createBox(String color) {

        ImageView imageView = new ImageView(
                new Image(getClass().getResourceAsStream("soup2.png"))
        );

        imageView.setFitWidth(120);
        imageView.setPreserveRatio(true);

        VBox box = new VBox(imageView);
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(200, 250);
        box.setStyle("-fx-background-color: " + color + ";");

        return box;
    }

    private String getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
}