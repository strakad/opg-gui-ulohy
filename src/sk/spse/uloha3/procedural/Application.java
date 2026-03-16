package sk.spse.uloha3.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Trieda pre procedurálne vytvorené GUI
 * Upravená tak, aby spĺňala požiadavky zadania (Informačné okno DOD)
 */
public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {

        // 1. Vytvorenie koreňového prvku BorderPane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20)); // Okraje celej aplikácie

        // --- VRCHNÁ ČASŤ (NADPIS) ---
        Label titleLabel = new Label("Stredná priemyselná škola elektrotechnická, Prešov");
        titleLabel.setFont(new Font(20));
        BorderPane.setAlignment(titleLabel, Pos.CENTER);
        BorderPane.setMargin(titleLabel, new Insets(0, 0, 20, 0)); // Medzera pod nadpisom
        root.setTop(titleLabel);

        // --- STREDNÁ ČASŤ (OBRÁZOK, TEXT, ODKAZ) ---
        HBox centerBox = new HBox(20); // Medzera medzi obrázkom a textom
        BorderPane.setAlignment(centerBox, Pos.CENTER);

        // Obrázok (ImageView)
        // Poznámka: Uistite sa, že 'spse.png' je v rovnakom balíčku, inak upravte cestu k súboru.
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResourceAsStream("spse.png"));
            imageView.setImage(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(200);
            imageView.setPreserveRatio(true);
        } catch (NullPointerException e) {
            System.err.println("Obrázok spse.png sa nenašiel. Skontrolujte jeho umiestnenie.");
        }

        // Text oznamu (TextArea)
        TextArea textArea = new TextArea(
                "Vážení rodičia a milí žiaci základných škôl,\n\n" +
                        "radi by sme Vás privítali v priestoroch našej školy dňa 10. 02. 2026 (utorok) " +
                        "od 13.00 do 17.00 h na Dni otvorených dverí, kde by sme Vám chceli " +
                        "predstaviť naše študijné odbory."
        );
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setFont(new Font(14));

        // Hyperlink
        Hyperlink hyperlink = new Hyperlink("https://www.spse-po.sk");
        hyperlink.setFont(new Font(15));

        // VBox pre text a link, aby boli pod sebou
        VBox textContainer = new VBox(10, textArea, hyperlink);
        HBox.setHgrow(textContainer, Priority.ALWAYS); // Aby textový box vyplnil zvyšný priestor
        VBox.setVgrow(textArea, Priority.ALWAYS);

        // Pridanie obrázku a textového kontajnera do stredového HBoxu
        centerBox.getChildren().addAll(imageView, textContainer);
        root.setCenter(centerBox);

        // --- SPODNÁ ČASŤ (TLAČIDLO) ---
        Button closeButton = new Button("Beriem na vedomie");
        closeButton.setPadding(new Insets(8, 15, 8, 15));

        // Akcia na ukončenie programu
        closeButton.setOnAction(e -> Platform.exit());

        // HBox na zarovnanie tlačidla doprava
        HBox bottomBox = new HBox(closeButton);
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        BorderPane.setMargin(bottomBox, new Insets(20, 0, 0, 0)); // Medzera nad tlačidlom
        root.setBottom(bottomBox);

        // --- NASTAVENIE SCÉNY A OKNA ---
        Scene scene = new Scene(root, 700, 400); // Nastavenie predvolenej veľkosti okna
        stage.setTitle("Declarative Application 3");
        stage.setScene(scene);
        stage.show();
    }
}