package willramanand.utils;

import willramanand.enums.ItemType;
import willramanand.interfaces.Item;

public abstract class Product implements Item {
  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  public Product(String name, String manufacturer, ItemType type) {
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

  public void setType(ItemType type) {
    this.type = type;
  }
  public ItemType getType() {
    return type;
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

