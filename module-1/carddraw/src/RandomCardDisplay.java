//Jessica Long-Heinicke 3.23.25

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardDisplay extends Application {

    private static final String CARD_DIRECTORY = "cards/";
    private static final int TOTAL_CARDS = 52;
    private static final int CARDS_TO_DISPLAY = 4;

    private List<ImageView> cardViews;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Random Card Display");

        // Create ImageViews for the cards
        cardViews = new ArrayList<>();
        for (int i = 0; i < CARDS_TO_DISPLAY; i++) {
            ImageView imageView = new ImageView();
            imageView.setFitWidth(100);
            imageView.setFitHeight(140);
            cardViews.add(imageView);
        }

        // Create an HBox to hold the card images
        HBox cardBox = new HBox(10);
        cardBox.setAlignment(Pos.CENTER);
        cardBox.getChildren().addAll(cardViews);

        // Create a Refresh button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> refreshCards());

        // Create a VBox to hold the HBox and the button
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(cardBox, refreshButton);

        // Set the initial cards
        refreshCards();

        // Set up the scene and stage
        Scene scene = new Scene(root, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void refreshCards() {
        // Generate a list of card numbers (1 to 52)
        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            cardNumbers.add(i);
        }

        // Shuffle the list to get random cards
        Collections.shuffle(cardNumbers);

        // Load and display the first four cards
        for (int i = 0; i < CARDS_TO_DISPLAY; i++) {
            String cardPath = CARD_DIRECTORY + cardNumbers.get(i) + ".png";
            Image cardImage = new Image(cardPath);
            cardViews.get(i).setImage(cardImage);
        }
    }
}