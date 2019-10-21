package willramanand;

import java.util.Date;

public class ProductionRecord {
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  public ProductionRecord(int productID) {
    this.productionNumber = 0;
    this.productID = productID;
    this.serialNumber = "0";
    this.dateProduced = new Date();
  }

  public ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  public int getProductionNum() {
    return productionNumber;
  }

  public int getProductID() {
    return productID;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public Date getProdDate() {
    return dateProduced;
  }

  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  @Override
  public String toString() {
    return "Prod. Num: " + this.productionNumber
        + " Product ID: " + this.productID
        + " Serial Num: " +this.serialNumber
        + " Date: " + this.dateProduced;
  }
}