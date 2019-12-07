package io.github.willramanand;

/**
 * The interface for Items.
 *
 * @author William Ramanand
 */
public interface Item {

  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();
}
