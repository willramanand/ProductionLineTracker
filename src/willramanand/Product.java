package willramanand;

import willramanand.interfaces.Item;

public abstract class Product implements Item {
  private int id;
  private String type;
  private String manufacturer;
  private String name;

  public Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  public int getId(){
    return id;
  }

  public void setName(String name){
    this.name = name;
  }
  public String getName() {
    return name;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }
  public String getManufacturer() {
    return manufacturer;
  }
  public String toString() {
    return "Name: " + name
        + "\nManufacturer: " + manufacturer
        + "\nType: " + type;
  }

}
