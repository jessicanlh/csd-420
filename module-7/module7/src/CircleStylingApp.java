//Jessica Long-Heinicke CSD 420 4.28.25

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStylingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Create four circles
        Circle circle1 = new Circle(50, 50, 30);
        circle1.getStyleClass().add("white-fill-black-stroke");

        Circle circle2 = new Circle(150, 50, 30);
        circle2.getStyleClass().add("white-fill-black-stroke");

        Circle circle3 = new Circle(50, 150, 30);
        circle3.setId("red-fill-green-stroke");

        Circle circle4 = new Circle(150, 150, 30);
        circle4.setId("red-fill-green-stroke");

        // Add circles to the pane
        root.getChildren().addAll(circle1, circle2, circle3, circle4);

        // Create a scene and link the external stylesheet
        Scene scene = new Scene(root, 300, 300);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("Circle Styling Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
