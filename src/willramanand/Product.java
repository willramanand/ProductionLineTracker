package willramanand;

public abstract class Product {
  private int id;
  private String type;
  private String manufacturer;
  private String name;

  public Product(String name) {
    this.name = name;
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
    return "Name:" + name
        + "/nManufacturer:" + manufacturer
        + "/nType:" + type;
  }

}
