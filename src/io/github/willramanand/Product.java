package io.github.willramanand;

/**
 * Abstract Class product for which all product objects are based on.
 *
 * @author William Ramanand
 */
public abstract class Product implements Item {

  /**
   * Stores id of product.
   */
  private int id;

  /**
   * Stores type of product.
   */
  private ItemType type;

  /**
   * Stores manufacturer of product.
   */
  private String manufacturer;

  /**
   * Stores name of product.
   */
  private String name;

  /**
   * Constructor of class product.
   * @param name sets name of product.
   * @param manufacturer sets manufacturer of product.
   * @param type sets type of product.
   */
  public Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * Gets of ID of product.
   * @return int ID
   */
  public int getId() {
    return id;
  }

  /**
   * Sets name of product.
   * @param name name to set to.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets name of product.
   * @return name of product as String.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets type of product.
   * @param type type to set to.
   */
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * Gets type of product.
   * @return type of product as ItemType.
   */
  public ItemType getType() {
    return type;
  }

  /**
   * Sets manufacturer of product.
   * @param manufacturer manufacturer to set to.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Gets manufacturer of product.
   * @return manufacturer as String
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Method for returning details of product as String.
   * @return String of product details.
   */
  public String toString() {
    return "Name: " + name
        + "\nManufacturer: " + manufacturer
        + "\nType: " + type;
  }
}

