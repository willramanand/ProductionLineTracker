package willramanand;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This is the Controller of the Production Line Tracker Application. It stores all major code
 * functionality within the program.
 */
public class Controller implements Initializable {

  /**
   * This constant variable stores the H2 Driver needed to initialize a connection to the database
   */
  final static String JDBC_DRIVER = "org.h2.Driver";

  /**
   * This constant variable stores the location of of the database for connection initialization.
   */
  final static String DB_URL = "jdbc:h2:./res/ProductionDB";

  /**
   * This constant stores a String that holds the Username needed to access the database.
   */
  final static String USER = "";

  /**
   * This constant stores a String that holds the Password needed to access the database.
   */
  final static String PASS = "";

  /**
   * Initializes the
   */
  private Connection conn = null;

  /**
   *
   */
  private Statement stmt = null;

  /**
   *
   */
  @FXML
  private Button recProdBtn, addProductBtn;

  /**
   *
   */
  @FXML
  private TextField prodNameField, manufacturerField;

  /**
   *
   */
  @FXML
  private ChoiceBox itemTypeChoice;

  @FXML
  private ComboBox<String> produceComboBox;

  @FXML
  public void initialize(URL url, ResourceBundle resources) {
    produceComboBox.setEditable(true);
    produceComboBox.getSelectionModel().selectFirst();
    produceComboBox.setItems(FXCollections.observableArrayList(getList()));
  }

  /**
   * @param actionEvent
   */
  @FXML
  public void addProductBtnPressed(ActionEvent actionEvent) {
    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql = "INSERT INTO PRODUCT(TYPE, MANUFACTURER, NAME ) VALUES ('TestType', ?, ? )";

      PreparedStatement preparedStatement =
          conn.prepareStatement(sql);

      preparedStatement.setString(1, manufacturerField.getText());
      preparedStatement.setString(2, prodNameField.getText());

      preparedStatement.executeUpdate();

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
      preparedStatement.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * @param actionEvent
   */
  @FXML
  public void recProdBtnPressed(ActionEvent actionEvent) {
    System.out.println("Hi!");
  }

  private List<String> getList() {

    List<String> results = new ArrayList<>();
    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql = "SELECT * FROM PRODUCT";

      ResultSet resultSet = stmt.executeQuery(sql);

      while (resultSet.next()) {
        results.add(resultSet.getString(1));
      }

    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
}
