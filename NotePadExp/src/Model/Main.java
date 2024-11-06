package Model;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try {
            // loading the fxml
            Pane pane = FXMLLoader.load(getClass().getResource("notepad.fxml"));

            // creating and initializing the scene.
            Scene scene = new Scene(pane);
            stage.setScene(scene);

            // setting the height and width of stage.
            stage.setWidth(1024);
            stage.setHeight(768);
            stage.setTitle("First");
            stage.show();

            // setting the App title
            stage.setTitle("Untitled - Notepad");

            // display the stage
            stage.show();

            scene.getStylesheets().add(getClass().getResource("/css/notepad.css").toExternalForm());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}