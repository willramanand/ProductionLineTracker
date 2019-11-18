package io.github.willramanand;

import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This is the Controller of the Production Line Tracker Application. It stores all major code
 * functionality within the program.
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
   * Creates the connection for the database.
   */
  private Connection conn = null;

  /**
   * Creates the variable for the statement for the database.
   */
  private Statement stmt = null;

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
   * The text area in the production log tab that displays production records.
   */
  @FXML
  private TextArea productionLogArea;

  /**
   * The table view that contains products.
   */
  @FXML
  private TableView<Product> productsTable = new TableView();

  /**
   * The list view on the produce tab that contains products to select.
   */
  @FXML
  private ListView<Product> produceList = new ListView();

  /**
   * List that contains Product objects from database for use in the program.
   */
  private ObservableList<Product> products;

  private ObservableList<ProductionRecord> productionRecords;

  /**
   * This method initializes the combo box in the produce tab.
   *
   * @param url       points to a needed resource
   * @param resources is the locale-specific resources available to the program.
   */
  public void initialize(URL url, ResourceBundle resources) {
    // Set values 1-10
    produceCombo.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

    // Set as editable
    produceCombo.setEditable(true);

    // Select default value of combo box
    produceCombo.getSelectionModel().selectFirst();

    // Add types to choice box
    itemTypeChoice.getItems().addAll(ItemType.values());

    // Test audio and movie player
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
        MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
      System.out.println();
    }

    setupProductTable();
    populateProductTable();
    setupProduceListView();

    productionRecords = FXCollections.observableArrayList();
    setupProductionLog();
    populateProductionLog();
  }

  /**
   * Method for quickly initializing the database.
   */
  public void initializeDB() {
    // Connection to the database
    try {
      Class.forName(JDBC_DRIVER);
      // uses an empty password for now but it will be addressed at a later time
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();
    } catch (ClassNotFoundException e) {
      // e.printStackTrace();
      System.out.println("Unable to find class");
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("Error in SQL please try again");
    }
  }

  /**
   * Method to quickly close the database.
   */
  public void closeDB() {
    try {
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Initializes the columns and sets the productsTable items to the products array list.
   */
  public void setupProductTable() {
    TableColumn<Product, String> productNameCol = new TableColumn<>("Name");
    TableColumn<Product, String> productManufacturerCol = new TableColumn<>("Manufacturer");
    TableColumn<Product, ItemType> productTypeCol = new TableColumn<>("Type");

    productNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    productManufacturerCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    productTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

    productsTable.getColumns().addAll(productNameCol, productManufacturerCol, productTypeCol);

    products = FXCollections.observableArrayList();
    productsTable.setItems(products);
  }

  /**
   * This method takes values from the database and populates the array list products.
   */
  public void populateProductTable() {

    initializeDB();

    products.clear();
    try {
      ResultSet resultSet;
      String query = "SELECT * FROM PRODUCT";
      resultSet = stmt.executeQuery(query);

      String productName;
      String productManufacturer;
      String productTypeCode;
      ItemType productType;

      while (resultSet.next()) {

        productName = resultSet.getString("NAME");
        productManufacturer = resultSet.getString("MANUFACTURER");
        productTypeCode = resultSet.getString("TYPE");

        productType = convertToType(productTypeCode);

        products.add(new Widget(productName, productManufacturer, productType));
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDB();
  }

  /**
   * When the Add Product button is pressed it adds a new entry into the database.
   */
  @FXML
  public void addProductBtnPressed() {
    initializeDB();
    try {

      // Create query
      String sql = "INSERT INTO PRODUCT(TYPE, MANUFACTURER, NAME ) VALUES (?, ?, ? )";

      // Set as prepared statement to put dynamic values
      PreparedStatement preparedStatement = conn.prepareStatement(sql);

      ItemType it = (ItemType) itemTypeChoice.getValue();

      // Insert dynamic values
      preparedStatement.setString(1, it.getCode());
      preparedStatement.setString(2, manufacturerField.getText());
      preparedStatement.setString(3, prodNameField.getText());

      // Execute query
      preparedStatement.executeUpdate();

      // Clean-up environment
      preparedStatement.close();
      populateProductTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDB();
  }

  /**
   * Sets the items for the Produce List View to the products array list.
   */
  public void setupProduceListView() {
    produceList.setItems(products);
  }


  /**
   * When the record production is pressed it outputs Hi! to console.
   */
  @FXML
  public void recProdBtnPressed() {
    Product productToBeAdded = produceList.getSelectionModel().getSelectedItem();
    String selectionName = productToBeAdded.getName();
    String selectionManufacturer = productToBeAdded.getManufacturer();
    ItemType selectionType = productToBeAdded.getType();

    Product selectedProduct = new Widget(selectionName, selectionManufacturer, selectionType);

    // Generate number of products
    for (int i = 1; i <= Integer.parseInt(produceCombo.getSelectionModel().getSelectedItem());
        i++) {
      ProductionRecord pr = new ProductionRecord(selectedProduct, i);
      addToProductionDB(pr);
      productionLogArea.appendText("\n" + pr.toString());
    }
  }

  public void addToProductionDB(ProductionRecord productionRecord) {
    initializeDB();
    try {

      // Create query
      String sql = "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES (?, ?, ?)";

      // Set as prepared statement to put dynamic values
      PreparedStatement preparedStatement = conn.prepareStatement(sql);

      // Insert dynamic values
      preparedStatement.setInt(1, productionRecord.getProductID());
      preparedStatement.setString(2, productionRecord.getSerialNum());
      preparedStatement.setDate(3, new java.sql.Date(productionRecord.getProdDate().getTime()));

      // Execute query
      preparedStatement.executeUpdate();

      // Clean-up environment
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDB();
  }

  public void setupProductionLog() {
    initializeDB();

    productionRecords.clear();
    try {
      ResultSet resultSet;
      String query = "SELECT * FROM PRODUCTIONRECORD";
      resultSet = stmt.executeQuery(query);

      int productNum;
      int productID;
      String productSerialNum;
      java.sql.Date dateProducedSQL;
      Date dateProduced;

      while (resultSet.next()) {

        productNum = resultSet.getInt("PRODUCTION_NUM");
        productID = resultSet.getInt("PRODUCT_ID");
        productSerialNum = resultSet.getString("SERIAL_NUM");
        dateProducedSQL = resultSet.getDate("DATE_PRODUCED");

        dateProduced = new Date(dateProducedSQL.getTime());
        ProductionRecord pr = new ProductionRecord(productNum, productID, productSerialNum, dateProduced);
        pr.setProductionNum(productNum);
        productionRecords.add(pr);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeDB();
  }

  public void populateProductionLog() {
    for (int i = 0; productionRecords.size() >  i; i++) {
      if (i < productionRecords.size()) {
        productionLogArea.appendText(productionRecords.get(i).toString() + "\n");
      } else {
        productionLogArea.appendText(productionRecords.get(i).toString());
      }
    }
  }
  /**
   * Converts a String ItemType to the ItemType type.
   *
   * @param inputString the String code or value for type
   * @return ItemType type
   */
  public ItemType convertToType(String inputString) {
    ItemType retType = ItemType.AUDIO;

    switch (inputString) {
      case "VI":
      case "VISUAL":
        retType = ItemType.VISUAL;
        break;
      case "AM":
      case "AUDIOMOBILE":
        retType = ItemType.AUDIOMOBILE;
        break;
      case "VM":
      case "VISUALMOBILE":
        retType = ItemType.VISUALMOBILE;
        break;
      default:
        break;
    }
    return retType;
  }
}
