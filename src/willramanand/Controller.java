package willramanand;

import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import willramanand.enums.ItemType;

/**
 * <p>This is the Controller of the Production Line Tracker Application. It stores all major code
 * functionality within the program.</p>
 *
 * @author William Ramanand
 */
public class Controller implements Initializable {

  /**
   * This constant variable stores the H2 Driver needed to initialize a connection to the database.
   */
  private static final String JDBC_DRIVER = "org.h2.Driver";

  /**
   * This constant variable stores the location of of the database for connection initialization.
   */
  private static final String DB_URL = "jdbc:h2:./res/ProductionDB";

  /**
   * This constant stores a String that holds the Username needed to access the database.
   */
  private static final String USER = "";

  /**
   * This constant stores a String that holds the Password needed to access the database.
   */
  private static final String PASS = "";

  /**
   * Represents the record production button using its fx:id from fxml.
   */
  @FXML
  private Button recProdBtn;

  /**
   * Represents the add product button using its fx:id from fxml.
   */
  @FXML
  private Button addProductBtn;

  /**
   * Represents the product name text field using its fx:id from fxml.
   */
  @FXML
  private TextField prodNameField;

  /**
   * Represents the manufacturer text field using its fx:id from fxml.
   */
  @FXML
  private TextField manufacturerField;

  /**
   * Represents the choice box in the program using its fx:id from fxml.
   */
  @FXML
  private ChoiceBox itemTypeChoice;

  /**
   * The combo box in the program that takes an array list using its fx:id from fxml.
   */
  @FXML
  private ComboBox<String> produceCombo;

  /**
   * This method initializes the combo box in the produce tab.
   *
   * @param url       points to a needed resource
   * @param resources is the locale-specific resources available to the program.
   */
  @FXML
  public void initialize(URL url, ResourceBundle resources) {
    // Set values 1-10
    produceCombo.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    // Set as editable
    produceCombo.setEditable(true);

    // Select default value of combo box
    produceCombo.getSelectionModel().selectFirst();

    // Add types to choice box
    itemTypeChoice.getItems().addAll(ItemType.values());
  }

  /**
   * When the Add Product button is pressed it adds a new entry into the database.
   */
  @FXML
  public void addProductBtnPressed() {
    try {
      // Initializes the connection variable to a null value.
      Connection conn;

      // Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // Create query
      String sql = "INSERT INTO PRODUCT(TYPE, MANUFACTURER, NAME ) VALUES (?, ?, ? )";

      // Set as prepared statement to put dynamic values
      PreparedStatement preparedStatement =
          conn.prepareStatement(sql);

      ItemType it = (ItemType) itemTypeChoice.getValue();

      // Insert dynamic values
      preparedStatement.setString(1, it.getCode() );
      preparedStatement.setString(2, manufacturerField.getText());
      preparedStatement.setString(3, prodNameField.getText());

      // Execute query
      preparedStatement.executeUpdate();

      // Clean-up environment
      conn.close();
      preparedStatement.close();
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();

    }
  }

  /**
   * When the record production is pressed it outputs Hi! to console.
   */
  @FXML
  public void recProdBtnPressed() {
    System.out.println("Hi!");
  }

}
