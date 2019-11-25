package io.github.willramanand;

import java.util.Date;

/**
 * Class for recording Production
 *
 * @author William Ramanand
 */
public class ProductionRecord {

  /** Stores production number. */
  private int productionNumber;

  /** Stores product ID. */
  private int productID;

  /** Stores serial number of product on production. */
  private String serialNumber;

  /** Stores date product was produced. */
  private Date dateProduced;


  /**
   * Constructor of production record.
   *
   * @param productID sets the product's id only.
   */
  public ProductionRecord(int productID) {
    this.productionNumber = 0;
    this.productID = productID;
    this.serialNumber = "0";
    this.dateProduced = new Date();
  }

  /**
   * Constructor of product record.
   *
   * @param productionNumber the production number.
   * @param productID the product's id.
   * @param serialNumber the serial number of product.
   * @param dateProduced the date produced.
   */
  public ProductionRecord(
      int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Constructor
   *
   * @param productProduced Product that was produced.
   * @param count number of product produced.
   */
  public ProductionRecord(Product productProduced, int count) {
    this.productID = productProduced.getId();
    if (productProduced.getManufacturer().length() >= 3) {
      this.serialNumber =
          productProduced.getManufacturer().substring(0, 3)
              + productProduced.getType().getCode()
              + String.format("%05d", count);
    } else if (productProduced.getManufacturer().length() == 2) {
      this.serialNumber =
          productProduced.getManufacturer().substring(0, 2)
              + productProduced.getType().getCode()
              + String.format("%05d", count);
    } else {
      System.out.println("Not a valid manufacturer name!");
    }
    this.dateProduced = new Date();
  }

  /**
   * Gets the production number.
   *
   * @return producton number
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * Gets product ID.
   *
   * @return product's id.
   */
  public int getProductID() {
    return productID;
  }

  /**
   * Gets serial number.
   *
   * @return the product's serial number.
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * Gets production date.
   *
   * @return date product was produced.
   */
  public Date getProdDate() {
    return new Date(this.dateProduced.getTime());
  }

  /**
   * Sets the production number.
   *
   * @param productionNumber the production number of product.
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * Sets the product's ID.
   *
   * @param productID the product's ID
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * Sets the serial number of the product.
   *
   * @param serialNumber the serial number of the product.
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Sets the date the product was produced.
   *
   * @param dateProduced the date the product was produced.
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Method for return the details of the production as a String.
   *
   * @return String of product details.
   */
  @Override
  public String toString() {
    return "Prod. Num: "
        + this.productionNumber
        + " Product ID: "
        + this.productID
        + " Serial Num: "
        + this.serialNumber
        + " Date: "
        + this.dateProduced;
  }
}
