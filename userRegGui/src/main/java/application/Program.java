package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {

    //This is our PrimaryStage (It contains everything)
    private Stage primaryStage;

    //This id the BorderPane of RootLayout
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        //First: Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("User Registration Form");

        //Second: Initialize RootLayout
        initRootLayout();

        //Third: Display the EmployeeOperations View
        showEmployeeView();
    }

    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First: load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Program.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second: show the scene containing the root layout
            Scene scene = new Scene(rootLayout); //Sending root layout to the scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.

            /*
             Give the controller access to the Program.
             RootLayoutController controller = loader.getController();
             controller.setMain(this);
             */

            //Third: show the primary stage
            primaryStage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Shows the Employee operations view inside the root layout.
    public void showEmployeeView() {
        try{
            //First: load EmployeeView from Employee.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Program.class.getResource("Employee.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();

            //Second: set Employee Operations view into the center of root layout.
            rootLayout.setCenter(employeeOperationsView);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}