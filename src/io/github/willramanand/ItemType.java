package io.github.willramanand;

/**
 * These enums are used to give products types.
 *
 * @author William Ramanand
 */
public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIOMOBILE("AM"),
  VISUALMOBILE("VM");

  /**
   * Contains code for types.
   */
  private final String code;

  /**
   * Sets the type's codes.
   *
   * @param code what the type's code is set to.
   */
  ItemType(String code) {
    this.code = code;
  }

  /**
   * Gets the code for the type.
   *
   * @return the code of the type.
   */
  public String getCode() {
    return code;
  }
}
