package willramanand;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class of the Production Line Tracker. It starts the application and sets the
 * screen dimensions.
 *
 * @author Will Ramanand
 */
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("ProductionLineTracker.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 680, 545));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
